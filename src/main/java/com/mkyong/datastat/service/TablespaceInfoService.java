package com.mkyong.datastat.service;

import com.mkyong.datastat.model.TableSpaceInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Roman_Frolov on 12/27/2016.
 */

@Service
@Repository
public class TablespaceInfoService {

    private static final Logger logger = LoggerFactory.getLogger(TablespaceInfoService.class);

    public static final String sql =
            "select\n" +
                    "   fs.tablespace_name,\n" +
                    "   (df.totalspace - fs.freespace),\n" +
                    "   fs.freespace,\n" +
                    "   df.totalspace,\n" +
                    "   round(100 * (fs.freespace / df.totalspace))\n" +
                    "from\n" +
                    "   (select\n" +
                    "      tablespace_name,\n" +
                    "      round(sum(bytes) / 1048576) TotalSpace\n" +
                    "   from\n" +
                    "      dba_data_files\n" +
                    "   group by\n" +
                    "      tablespace_name\n" +
                    "   ) df,\n" +
                    "   (select\n" +
                    "      tablespace_name,\n" +
                    "      round(sum(bytes) / 1048576) FreeSpace\n" +
                    "   from\n" +
                    "      dba_free_space\n" +
                    "   group by\n" +
                    "      tablespace_name\n" +
                    "   ) fs\n" +
                    "where\n" +
                    "   df.tablespace_name = fs.tablespace_name";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static  List<TableSpaceInfo> getInfo() {
        ArrayList<TableSpaceInfo> infoList = new ArrayList<>();
        infoList.add(new TableSpaceInfo("SYSTEM", "99.38", "1520", "1510.56", "9.44"));
        infoList.add(new TableSpaceInfo("DATA", "89.38", "106629", "95691.94", "10938"));

        return infoList;
    }


    public List<TableSpaceInfo> getTablespaces() {
        ArrayList<TableSpaceInfo> list = new ArrayList<>();
        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet(sql);

        while (sqlRowSet.next()) {
            logger.debug("Name:" + sqlRowSet.getString(1) + ", free_size(mb): " + sqlRowSet.getString(2));
            TableSpaceInfo row = new TableSpaceInfo(sqlRowSet.getString(1),
                    sqlRowSet.getString(2), sqlRowSet.getString(3),
                    sqlRowSet.getString(4), sqlRowSet.getString(5));

            list.add(row);
        }

        return list;
    }

}


