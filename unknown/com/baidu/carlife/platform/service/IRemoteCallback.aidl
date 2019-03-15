package com.baidu.carlife.platform.service;
interface IRemoteCallback {
	void onServerError(in int errorNo,in String errorMsg);
}