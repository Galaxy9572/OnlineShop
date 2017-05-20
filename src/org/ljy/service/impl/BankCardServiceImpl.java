package org.ljy.service.impl;

import com.github.pagehelper.PageHelper;
import org.ljy.common.PagedResult;
import org.ljy.dao.BankCardMapper;
import org.ljy.domain.BankCard;
import org.ljy.domain.BankCardExample;
import org.ljy.service.BankCardService;
import org.ljy.util.BeanUtil;
import org.ljy.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service("bankCardService")
public class BankCardServiceImpl implements BankCardService {
    private Logger LOG = LoggerFactory.getLogger(this.getClass());
    @Resource
    private BankCardMapper bankCardMapper;

    @Override
    public long countByExample(BankCardExample example) {
        return bankCardMapper.countByExample(example);
    }

    @Override
    public boolean addBankCard(BankCard bankCard) {
        try {
            Date date = new Date();
            bankCard.setCreateTime(date);
            bankCard.setModifyTime(date);
            int flag = bankCardMapper.insertSelective(bankCard);
            return flag > 0;
        } catch (Exception e) {
            LOG.warn(e.getMessage(),e);
            return false;
        }
    }

    @Override
    public boolean deleteBankCardByBankCardId(Long id) {
        try {
            int flag = bankCardMapper.deleteByPrimaryKey(id);
            return flag > 0;
        } catch (Exception e) {
            LOG.warn(e.getMessage(),e);
            return false;
        }
    }

    @Override
    public boolean updateBankCard(BankCard bankCard) {
        try {
            int flag = bankCardMapper.updateByPrimaryKeySelective(bankCard);
            return flag > 0;
        } catch (Exception e) {
            LOG.warn(e.getMessage(),e);
            return false;
        }
    }

    @Override
    public List<BankCard> queryBankCard(Long userId) {
        List<BankCard> lists;
        BankCardExample example = new BankCardExample();
        try {
            example.or().andUserIdEqualTo(userId);
            lists = bankCardMapper.selectByExample(example);
            return lists;
        } catch (Exception e) {
            LOG.warn(e.getMessage(),e);
            return null;
        }
    }

    @Override
    public PagedResult queryBankCardByConditionByPage(String queryType, String condition, Integer pageNo, Integer pageSize) {
        pageNo = pageNo == null ? 1 : pageNo;
        pageSize = pageSize == null ? 10 : pageSize;
        PageHelper.startPage(pageNo, pageSize);  //startPage是告诉拦截器说我要开始分页了。分页参数是这两个。
        List<BankCard> result = null;
        BankCardExample example = new BankCardExample();
        if (StringUtil.isNotNullAndNotEmpty(queryType)) {
            int queryInt = Integer.parseInt(queryType);
            switch (queryInt) {
                case 0:
                    result = bankCardMapper.selectByExample(example);
                    break;
                case 1:
                    example.or().andBankNameEqualTo(condition);
                    result = bankCardMapper.selectByExample(example);
                    break;
                default:
                    example.or().andBankCardIdEqualTo(Long.parseLong(condition));
                    result = bankCardMapper.selectByExample(example);
            }
        }
        return BeanUtil.toPagedResult(result);
    }

}
