package com.cms.balance.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cms.balance.mapper.CmsBalanceSheetInfoMapper;
import com.cms.balance.model.CmsBalanceSheetInfo;
import com.remind.bpf.common.page.Page;

@Service("balanceService")
public class BalanceServiceImpl implements IBalanceService {

	@Resource(name="cmsBalanceSheetInfoMapper")
	private CmsBalanceSheetInfoMapper mapper;
	
	@Override
	public List<CmsBalanceSheetInfo> queryMenuList(Integer type) {
		Page page = new Page();
		page.setCurrentPage(0);
		page.setCurrentResult(10);
		page.setEntityOrField(false);
		CmsBalanceSheetInfo inf = new CmsBalanceSheetInfo();
		inf.setBs_number("S");
		return mapper.query(inf);
	}

}
