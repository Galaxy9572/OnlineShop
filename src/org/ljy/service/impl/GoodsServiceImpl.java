package org.ljy.service.impl;

import com.github.pagehelper.PageHelper;
import org.ljy.common.PagedResult;
import org.ljy.dao.GoodsMapper;
import org.ljy.domain.Goods;
import org.ljy.domain.GoodsExample;
import org.ljy.service.GoodsService;
import org.ljy.util.BeanUtil;
import org.ljy.util.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {

    @Resource
    private GoodsMapper goodsMapper;

    @Override
    public long countByExample(GoodsExample example) {
        return goodsMapper.countByExample(example);
    }

    @Override
    public boolean addGoods(Goods goods) {
        int flag = goodsMapper.insertSelective(goods);
        return flag > 0;
    }

    @Override
    public boolean deleteGoodsById(Long goodsId) {
        int flag = goodsMapper.deleteByPrimaryKey(goodsId);
        return flag > 0;
    }

    @Override
    public boolean updateGoods(Goods goods) {
        int flag = goodsMapper.updateByPrimaryKeySelective(goods);
        return flag > 0;
    }

    @Override
    public List<Goods> queryGoods(GoodsExample example) {
        return goodsMapper.selectByExampleWithBLOBs(example);
    }

    @Override
    public PagedResult queryGoodsByPage(String goodsType, String goodsName, Integer pageNo, Integer pageSize) {
        pageNo = pageNo == null ? 1 : pageNo;
        pageSize = pageSize == null ? 10 : pageSize;
        PageHelper.startPage(pageNo, pageSize);
        List<Goods> result = null;
        GoodsExample example = new GoodsExample();
        int goodsTypeInt = 0;
        if (StringUtil.isNotNullAndNotEmpty(goodsName)) {
            example.or().andGoodsNameLike("%" + goodsName + "%");
        }
        switch (goodsTypeInt) {
            case 0:
                result = goodsMapper.selectByExample(example);
                break;
            default:
                example.or().andGoodsTypeEqualTo(goodsTypeInt);
                result = goodsMapper.selectByExample(example);
                break;
        }
        return BeanUtil.toPagedResult(result);
    }

}
