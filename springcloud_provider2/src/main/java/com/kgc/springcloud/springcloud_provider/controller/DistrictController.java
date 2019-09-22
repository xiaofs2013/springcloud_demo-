package com.kgc.springcloud.springcloud_provider.controller;

import com.kgc.springcloud.springcloud_provider.mapper.DistrictMapper;
import com.kgc.springcloud.springcloud_provider.pojo.District;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@ResponseBody
public class DistrictController {

    @Autowired(required = false)
    private DistrictMapper districtMapper;

    @RequestMapping("/GetDistrict")
    public List<District> GetDistrict() {

        List<District> list = districtMapper.selectByExample(null);

        return list;

    }

}
