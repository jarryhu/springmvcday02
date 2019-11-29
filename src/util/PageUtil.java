package util;

import net.sf.json.JSONArray;
import pojo.User;

import java.util.HashMap;
import java.util.Map;

public class PageUtil {
    public static HashMap getPageParamer(User user, int page, int limit) {
        int pagestart = (page - 1) * limit;
        HashMap map = new HashMap();
        map.put("pagestart", pagestart);
        map.put("pagesize", limit);
        map.put("user_name", user.getUser_name());
        map.put("user_major", user.getUser_major());
        return map;
    }

    public static Map<String, Object> getDataForPage(int page, int limit, Object o, int size) {
        Map<String, Object> tableData = new HashMap<String, Object>();
        //这是layui要求返回的json数据格式
        JSONArray data = JSONArray.fromObject(o);
        tableData.put("data", data);
       
        tableData.put("code", "0");
        tableData.put("msg", "");
        //将全部数据的条数作为count传给前台（一共多少条）
        tableData.put("count", size);
        //将分页后的数据返回（每页要显示的数据）

        return tableData;
    }
}
