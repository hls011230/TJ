package com.hls.hlsservicerider.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hls.internalcommon.dto.Rider;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface RiderMapper extends BaseMapper<Rider> {
    public int selectRiderCountByCityCode(@Param("cityCode") String cityCode);

}
