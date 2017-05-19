package org.ljy.service.impl;

import com.github.pagehelper.PageHelper;
import org.ljy.common.PagedResult;
import org.ljy.dao.ShoppingCartMapper;
import org.ljy.domain.ShoppingCart;
import org.ljy.domain.ShoppingCartExample;
import org.ljy.service.ShoppingCartService;
import org.ljy.util.BeanUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service("shoppingService")
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private Logger LOG = LoggerFactory.getLogger(this.getClass());

	@Resource
	private ShoppingCartMapper shoppingCartMapper;

	@Override
	public long countByExample(ShoppingCartExample example) {
		return shoppingCartMapper.countByExample(example);
	}

	@Override
	public boolean addToCart(ShoppingCart shoppingCart) {
        int flag = 0;
        try {
            Date date = new Date();
            shoppingCart.setCreateTime(date);
            shoppingCart.setModifyTime(date);
            flag = shoppingCartMapper.insertSelective(shoppingCart);
            return flag > 0;
        } catch (Exception e) {
            LOG.warn(e.getMessage(),e);
            return false;
        }
	}

	@Override
	public boolean removeFromCart(Long cartId) {
        try {
            int flag = shoppingCartMapper.deleteByPrimaryKey(cartId);
            return flag > 0;
        } catch (Exception e) {
            LOG.warn(e.getMessage(),e);
            return false;
        }
    }

    @Override
    public PagedResult queryShoppingCartByPage(Long userId, Integer pageNo, Integer pageSize) {
        PagedResult result;
        List<ShoppingCart> lists;
        ShoppingCartExample example = new ShoppingCartExample();
        pageNo = pageNo == null ? 1 : pageNo;
        pageSize = pageSize == null ? 10 : pageSize;
        PageHelper.startPage(pageNo, pageSize);
        try {
            example.or().andUserIdEqualTo(userId);
            lists = shoppingCartMapper.selectByExample(example);
            return BeanUtil.toPagedResult(lists);
        } catch (Exception e) {
            LOG.warn(e.getMessage(),e);
            return null;
        }
    }

}
