package com.web.recruit.service;

import com.web.recruit.entity.Company;
import com.web.recruit.entity.Position;

import java.util.List;
import java.util.Map;

/**
 * @author Tracy
 * @date 2020/6/6 18:08
 */
public interface CompanyService {
    Company getCompanyByName(String name);

    Company getCompanyById(Integer companyId);

    List<Company> getAllCompanies();

    List<Company> getCompaniesByKey(String key);

    List<Company> getRequiredCompanies(Company company);

}
