package org.ljy.service.impl;

import com.github.pagehelper.PageHelper;
import org.apache.log4j.Logger;
import org.ljy.common.PagedResult;
import org.ljy.dao.ShopMapper;
import org.ljy.dao.UserMapper;
import org.ljy.domain.Shop;
import org.ljy.domain.ShopExample;
import org.ljy.domain.User;
import org.ljy.domain.UserExample;
import org.ljy.enums.UserType;
import org.ljy.service.ShopService;
import org.ljy.service.UserService;
import org.ljy.util.BeanUtil;
import org.ljy.util.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service("shopService")
public class ShopServiceImpl implements ShopService {
    private static Logger LOG = Logger.getLogger(ShopServiceImpl.class);
    @Resource
    private UserMapper userMapper;

	@Resource
	private ShopMapper shopMapper;

    @Override
    public long countByExample(ShopExample example) {
        return shopMapper.countByExample(example);
    }

    @Override
    public boolean checkIfCanOpen(User user, Shop shop) {
        boolean bool = false;
        try {
            if(user.getUserId() !=null && StringUtil.isNotNullAndNotEmpty(shop.getShopName())){
                ShopExample example = new ShopExample();
                example.or().andUserIdEqualTo(user.getUserId());
                long result = shopMapper.countByExample(example);
                if(result <= 0){
                    bool = true;
                }
            }
            return bool;
        } catch (Exception e) {
            LOG.warn(e.getMessage(),e);
            return false;
        }
    }

    @Override
	public Shop openShop(User user, Shop shop) {
		Shop result = null;
        try {
            if(user.getUserId() !=null && StringUtil.isNotNullAndNotEmpty(shop.getShopName())){
                Long userId = user.getUserId();
                Date date = new Date();
                ShopExample example =new ShopExample();
                example.or().andUserIdEqualTo(userId);
                shop.setUserId(userId);
                shop.setCreateTime(date);
                shop.setModifyTime(date);
                int flag = shopMapper.insertSelective(shop);
                List<Shop> userShop = shopMapper.selectByExampleWithBLOBs(example);
                user.setUserType(UserType.SELLER.key());
                int isSuccess = userMapper.updateByPrimaryKeySelective(user);
                if(flag > 0 && isSuccess > 0){
                    result = userShop.get(0);
                }
            }
            return result;
        } catch (Exception e) {
            LOG.warn(e.getMessage(),e);
            return null;
        }
    }

    @Override
    public Shop getShop(ShopExample example) {
        return shopMapper.selectByExampleWithBLOBs(example).get(0);
    }

    @Override
	public PagedResult selectByExampleWithBLOBsByPage(ShopExample example, Integer pageNo, Integer pageSize) {
		pageNo = pageNo == null?1:pageNo;
		pageSize = pageSize == null?10:pageSize;
		PageHelper.startPage(pageNo,pageSize);
		return BeanUtil.toPagedResult(shopMapper.selectByExampleWithBLOBs(example));
	}

	@Override
	public PagedResult selectByExampleByPage(ShopExample example, Integer pageNo, Integer pageSize) {
		pageNo = pageNo == null?1:pageNo;
		pageSize = pageSize == null?10:pageSize;
		PageHelper.startPage(pageNo,pageSize);
		return BeanUtil.toPagedResult(shopMapper.selectByExampleWithBLOBs(example));
	}

}
