package com.hls.hlsserviceprice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hls.internalcommon.dto.PriceRule;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Repository
public interface PriceRuleMapper extends BaseMapper<PriceRule> {

}
