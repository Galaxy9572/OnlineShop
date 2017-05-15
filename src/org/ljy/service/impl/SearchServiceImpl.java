package org.ljy.service.impl;

import org.apache.log4j.Logger;
import org.ljy.dao.GoodsMapper;
import org.ljy.dao.ShopMapper;
import org.ljy.dao.UserMapper;
import org.ljy.domain.GoodsExample;
import org.ljy.domain.ShopExample;
import org.ljy.domain.UserExample;
import org.ljy.service.SearchService;
import org.ljy.util.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("searchService")
public class SearchServiceImpl implements SearchService {
    private static Logger LOG = Logger.getLogger(SearchServiceImpl.class);
    @Resource
    private UserMapper userMapper;

    @Resource
    private GoodsMapper goodsMapper;

    @Resource
    private ShopMapper shopMapper;

    @Override
    public List<?> search(String keyWord, int type) {
        boolean bool = StringUtil.isNotNullAndNotEmpty(keyWord);
        List<?> result = new ArrayList<>();
        try {
            if (bool) {//非空
                switch (type) {
                    case 1://用户
                        UserExample userExample = new UserExample();
                        userExample.or().andUserNameLike("%" + keyWord + "%");
                        result = userMapper.selectByExample(userExample);
                        break;
                    case 2://商品
                        GoodsExample goodsExample = new GoodsExample();
                        goodsExample.or().andGoodsNameLike("%" + keyWord + "%");
                        result = goodsMapper.selectByExample(goodsExample);
                        break;
                    case 3://商家
                        ShopExample shopExample = new ShopExample();
                        shopExample.or().andShopNameLike("%" + keyWord + "%");
                        result = shopMapper.selectByExample(shopExample);
                        break;
                    default:
                        return null;
                }
                return result;
            } else {
                return null;
            }
        } catch (Exception e) {
            LOG.warn("SearchService search异常"+e.getMessage(),e);
            return null;
        }
    }
}
