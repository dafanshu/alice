package com.cms.balance.service;

import java.util.List;

import com.cms.balance.model.CmsBalanceSheetInfo;

public interface IBalanceService {
	public List<CmsBalanceSheetInfo> queryMenuList(Integer type);
}
