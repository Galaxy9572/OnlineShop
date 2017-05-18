package org.ljy.service.impl;

import com.github.pagehelper.PageHelper;
import org.ljy.common.PagedResult;
import org.ljy.dao.GoodsMapper;
import org.ljy.domain.Goods;
import org.ljy.domain.GoodsExample;
import org.ljy.service.GoodsService;
import org.ljy.util.BeanUtil;
import org.ljy.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {
    private Logger LOG = LoggerFactory.getLogger(this.getClass());
    @Resource
    private GoodsMapper goodsMapper;

    @Override
    public long countByExample(GoodsExample example) {
        return goodsMapper.countByExample(example);
    }

    @Override
    public boolean addGoods(Goods goods) {
        try {
            Date date = new Date();
            goods.setCreateTime(date);
            goods.setModifyTime(date);
            int flag = goodsMapper.insertSelective(goods);
            return flag > 0;
        } catch (Exception e) {
            LOG.warn(e.getMessage(),e);
            return false;
        }
    }

    @Override
    public boolean deleteGoodsById(Long goodsId) {
        try {
            int flag = goodsMapper.deleteByPrimaryKey(goodsId);
            return flag > 0;
        } catch (Exception e) {
            LOG.warn(e.getMessage(),e);
            return false;
        }
    }

    @Override
    public boolean updateGoods(Goods goods) {
        try {
            int flag = goodsMapper.updateByPrimaryKeySelective(goods);
            return flag > 0;
        } catch (Exception e) {
            LOG.warn(e.getMessage(),e);
            return false;
        }
    }

    @Override
    public Goods querySingleGoods(Long goodsId) {
        try {
            return goodsMapper.selectByPrimaryKey(goodsId);
        } catch (Exception e) {
            LOG.warn(e.getMessage(),e);
            return null;
        }
    }

    @Override
    public List<Goods> queryGoodsByType(int type) {
        List<Goods> result;
        GoodsExample example = new GoodsExample();
        try {
            example.or().andGoodsTypeEqualTo(type);
            result = goodsMapper.selectByExampleWithBLOBs(example);
            return result;
        } catch (Exception e) {
            LOG.warn(e.getMessage(),e);
            return null;
        }
    }

    @Override
    public PagedResult queryGoodsByPage(String goodsType, String goodsName, Integer pageNo, Integer pageSize) {
        pageNo = pageNo == null ? 1 : pageNo;
        pageSize = pageSize == null ? 10 : pageSize;
        PageHelper.startPage(pageNo, pageSize);
        List<Goods> result;
        GoodsExample example = new GoodsExample();
        int goodsTypeInt = 0;
        try {
            if (StringUtil.isNotNullAndNotEmpty(goodsName)) {
                example.or().andGoodsNameLike("%" + goodsName + "%");
            }
            switch (goodsTypeInt) {
                case 0:
                    result = goodsMapper.selectByExampleWithBLOBs(example);
                    break;
                default:
                    example.or().andGoodsTypeEqualTo(goodsTypeInt);
                    result = goodsMapper.selectByExample(example);
                    break;
            }
            return BeanUtil.toPagedResult(result);
        } catch (Exception e) {
            LOG.warn(e.getMessage(),e);
            return null;
        }
    }



}
