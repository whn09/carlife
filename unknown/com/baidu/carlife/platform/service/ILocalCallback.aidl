package com.baidu.carlife.platform.service;
import com.baidu.carlife.model.MusicSongModel;
import com.baidu.carlife.platform.model.CLAlbum;
interface ILocalCallback {
	void onRemoteClinetConnected(in String name);
	void onRemoteClientDisconnected(in String name);
	void onServerError(in int errorNo,in String errorMsg);
	void onGetSongList(in int errorNo,in String errorMsg,in String name,in String songListId,in List<MusicSongModel> songList,in int pn,in int rn,in int total);
	void onGetSong(in int errorNo,in String errorMsg,in String name,in String songId,in long downloadSize,long totalSize,in boolean stop);
	void onGetAlbumList(in int errorNo,in String errorMsg,in String name,in List<CLAlbum> albumList);
}