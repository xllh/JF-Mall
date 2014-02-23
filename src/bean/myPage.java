package bean;

import java.util.List;

import com.jfinal.plugin.activerecord.Page;

public class myPage<T> extends Page<T> {

	public myPage(List<T> list, int pageNumber, int pageSize, int totalPage,
			int totalRow) {
		super(list, pageNumber, pageSize, totalPage, totalRow);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
