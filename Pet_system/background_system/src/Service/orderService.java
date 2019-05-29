package Service;

import Bean.PageBean;

public interface orderService {
    public  PageBean getPageBean(int pageSize, int page);
}
