package com.jf.monitor.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/test")
public class TestController {

    //xxx
	@RequestMapping("/test")
	public Object test(@RequestBody String data) {
		System.out.println("data:"+data);
		Map map = JSONObject.parseObject(data, Map.class);
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Object o=new Object();
		//研发
		if(("yf").equals(map.get("user"))){
			if(map.get("model").equals("接口监控")){
				Date d1 = new Date();
				d1.setDate(1);
				Date d12 = new Date();
				d12.setDate(2);
				Date d13 = new Date();
				d13.setDate(3);
				Map result=new HashMap();
				result.put(sf.format(new Date()),50);
				result.put(sf.format(d1),50);
				result.put(sf.format(d12),60);
				result.put(sf.format(d13),70);
				o=result;
			}
		}
		//运维
		else if(("yw").equals(map.get("user"))){
			if(map.get("model").equals("jvm")){
				List list=new ArrayList();
				HashMap m1 = new HashMap();
				HashMap m2 = new HashMap();
				m1.put("value",(int)(Math.random()*1000));
				m1.put("name","剩余内存");
				m2.put("value",(int)(Math.random()*1000));
				m2.put("name","使用内存");
				list.add(m1);
				list.add(m2);
				o=list;
			}
			if(map.get("model").equals("cpu信息")){
				List list=new ArrayList();
				HashMap m1 = new HashMap();
				m1.put("value",(int)(Math.random()*100));
				m1.put("name","cpu使用率");
				list.add(m1);
				o=list;
			}
		}
		System.out.println(o.toString());
		return o;
	}

}
