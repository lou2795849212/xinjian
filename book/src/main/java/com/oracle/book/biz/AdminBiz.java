package com.oracle.book.biz;

import com.oracle.book.entity.Admin;

public interface AdminBiz {

	boolean findByNameAndPwd(Admin admin);

}
