package org.ljy.service;

import org.ljy.common.PagedResult;
import org.ljy.domain.BankCard;
import org.ljy.domain.BankCardExample;

import java.util.List;

public interface BankCardService {
    long countByExample(BankCardExample example);

    boolean addBankCard(BankCard bankCard);

    boolean deleteBankCardByBankCardId(Long id);

    boolean updateBankCard(BankCard bankCard);

    List<BankCard> queryBankCard(Long userId);

    PagedResult queryBankCardByConditionByPage(String queryType, String condition, Integer pageNumber, Integer pageSize);
}
