package com.web.recruit.controller.company;
import com.web.recruit.controller.BaseController;
import com.web.recruit.entity.*;
import com.web.recruit.service.impl.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @author Tracy
 * @date 2020/6/6 18:03
 */
@Controller
@RequestMapping("/company")
public class CompanyController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private PositionServiceImpl positionService;

    @Autowired
    private CompanyServiceImpl companyService;

    @Autowired
    private FavorServiceImpl favorService;

    @Autowired
    private ResumeServiceImpl resumeService;

    @Autowired
    private CategoryServiceImpl categoryService;


/**
 * 发起职位搜索请求，返回所有职位给页面
 * @param map
 * @return
 */
@RequestMapping("/searchList")
public String getAllCompanies(Map<String, Object> map) {
    List<Company> companies = companyService.getAllCompanies();
    map.put("companies", companies);

//    //获取公司
//    List<Company> companies = companyService.getAllCompanies();
//    map.put("companies", companies);

    logger.info(companies.toString());


    return "forward:/clist.html";
}

    @RequestMapping("/searchByKey")
    public String searchCompaniesByKey(@RequestParam("keyword") String keyword,
                                      Map<String, Object> map) {
        List<Company> companies = companyService.getCompaniesByKey(keyword);
        map.put("companies", companies);

//        List<Company> companies = companyService.getAllCompanies();
//        map.put("companies", companies);

        logger.info("根据keyword查找...");
        return "forward:/clist.html";
    }

    @RequestMapping("/searchRequired")
    public String searchRequiredCompany(@RequestParam("name") String name,
                                        @RequestParam("address") String address,
                                        @RequestParam("type") String type,
                                        Map<String, Object> map) {
        Company company=new Company();
        company.setCompanyName(name);
        company.setCompanyAddress(address);
        company.setCompanyType(type);
        List<Company> companies = companyService.getRequiredCompanies(company);
        map.put("companies", companies);
        logger.info("按需查找...");
        return "forward:/clist.html";

    }

    @RequestMapping("/{id}")
    public String companyDetail(@PathVariable("id") Integer id,
                                HttpServletRequest request,
                                Map<String, Object> map) {

        Company company=companyService.getCompanyById(id);
        map.put("company",company);
        return "forward:/cdetail.html";

    }

}