package wechat.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import wechat.dao.TypeDao;
import wechat.model.Type;
import wechat.service.ITypeService;

/**
 *@author Huang_Shuxing
 *2016年9月1日 下午10:34:24
 */
@Service("typeService")
public class TypeServiceImpl implements ITypeService {
	
	@Resource
	private TypeDao dao ;
	@Override
	public List<Type> getListAllType() {
		List<Type> list =dao.getListAllType(); 
		return list ;
	}

}
