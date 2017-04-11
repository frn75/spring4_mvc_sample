package com.mkyong.datastat.service;

import com.mkyong.datastat.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by Roman_Frolov on 12/30/2016.
 */

@Service
@Repository
public class UserInfoService {

    private final String sql =
            "SELECT username, default_tablespace, created creationdate, account_status status \n" +
            "FROM dba_users\n" +
            "where account_status = 'OPEN' AND default_tablespace not in ('SYSTEM','SYSAUX')\n" +
            "order by username";

    private static final Logger logger = LoggerFactory.getLogger(UserInfoService.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<UserInfo> getUsers() {
        List<UserInfo> userInfos = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(UserInfo.class));

        logger.debug("found users: " + userInfos.size());

        return userInfos;
    }
}
