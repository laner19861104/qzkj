package com.bip.common.upload.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bip.common.upload.dao.JocFileDao;
import com.bip.common.upload.listener.JocFileListener;
import com.bip.common.upload.po.JocFile;
import com.bip.common.upload.service.JocFileService;
@Service
public class JocFileServiceImpl implements JocFileService {
	
	private JocFileDao jocFileDao;
	private List<JocFileListener> listeners;
	
	public int delete(JocFile bean) {
		if (null != this.listeners) {
			for (JocFileListener l : this.listeners) {
				l.preDelete(bean);
			}
		}
		if (null != this.listeners) {
			for (JocFileListener l : this.listeners) {
				l.onDelete();
			}
		}
		jocFileDao.delete(bean);
		if (null != this.listeners) {
			for (JocFileListener l : this.listeners) {
				l.afterDelete();
			}
		}
		return 0;
	}

	public int delete(String uuid) {
		JocFile bean = jocFileDao.get(uuid);
		if (null == bean) {
			return -1;
		}
		if (null != this.listeners) {
			for (JocFileListener l : this.listeners) {
				l.preDelete(bean);
			}
		}
		if (null != this.listeners) {
			for (JocFileListener l : this.listeners) {
				l.onDelete();
			}
		}
		jocFileDao.delete(bean);
		if (null != this.listeners) {
			for (JocFileListener l : this.listeners) {
				l.afterDelete();
			}
		}
		return 0;
	}

	public JocFile save(JocFile bean) {
		jocFileDao.save(bean);
		return bean;
	}

	public JocFile update(JocFile bean) {
		jocFileDao.update(bean);
		return bean;
	}

	@Autowired
	public void setJocFileDao(JocFileDao jocFileDao) {
		this.jocFileDao = jocFileDao;
	}
	@Autowired
	public void setListeners(List<JocFileListener> listeners) {
		this.listeners = listeners;
	}

	@Override
	public JocFile get(String uuid) {
		return this.jocFileDao.get(uuid);
		
	}

}
