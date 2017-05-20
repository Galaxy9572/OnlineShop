package org.ljy.service.impl;

import com.github.pagehelper.PageHelper;
import org.ljy.common.PagedResult;
import org.ljy.dao.OrdersMapper;
import org.ljy.domain.Orders;
import org.ljy.domain.OrdersExample;
import org.ljy.service.OrdersService;
import org.ljy.util.BeanUtil;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service("ordersService")
public class OrdersServiceImpl implements OrdersService {
    private org.slf4j.Logger LOG = LoggerFactory.getLogger(this.getClass());
    @Resource
    private OrdersMapper ordersMapper;

    @Override
    public long countByExample(OrdersExample example) {
        return ordersMapper.countByExample(example);
    }

    @Override
    public boolean addOrder(Orders orders) {
        try {
            Date date = new Date();
            orders.setCreateDate(date);
            orders.setModifyDate(date);
            int flag = ordersMapper.insertSelective(orders);
            return flag > 0;
        } catch (Exception e) {
            LOG.warn(e.getMessage(), e);
            return false;
        }
    }

    @Override
    public boolean deleteOrderByOrderId(Long ordersId) {
        try {
            int flag = ordersMapper.deleteByPrimaryKey(ordersId);
            return flag > 0;
        } catch (Exception e) {
            LOG.warn(e.getMessage(), e);
            return false;
        }
    }

    @Override
    public boolean updateOrder(Orders orders) {
        try {
            int flag = ordersMapper.updateByPrimaryKey(orders);
            return flag > 0;
        } catch (Exception e) {
            LOG.warn(e.getMessage(), e);
            return false;
        }
    }


    @Override
    public PagedResult queryOrdersByPage(String queryType,String userId,String statement,Integer pageNo, Integer pageSize) {
        OrdersExample example = new OrdersExample();
        PagedResult result;
        pageNo = pageNo == null ? 1 : pageNo;
        pageSize = pageSize == null ? 10 : pageSize;
        PageHelper.startPage(pageNo, pageSize);
        try {
            if("buyer".equals(queryType)){
                example.or().andUserIdEqualTo(Long.parseLong(userId));
            }else{
                example.or().andSellerIdEqualTo(Long.parseLong(userId));
            }
            int statementInt = Integer.parseInt(statement);
            switch (statementInt) {
                case 0:
                    result = BeanUtil.toPagedResult(ordersMapper.selectByExample(null));
                    break;
                default:
                    example.or().andStatementEqualTo(statementInt);
                    result = BeanUtil.toPagedResult(ordersMapper.selectByExample(example));
                    break;
            }
            return result;
        } catch (Exception e) {
            LOG.warn(e.getMessage(), e);
            return null;
        }
    }
}
