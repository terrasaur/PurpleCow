package cow;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ItemServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	
	// TODO: make this a database/utility class
	private HashMap <Integer, Item> itemMap ;
	
	public void init() {
		itemMap = new HashMap<Integer, Item>();
		// some garbage
		itemMap.put(1, new Item(1, "apples"));
		itemMap.put(2, new Item(2, "bananas"));
		itemMap.put(3, new Item(3, "cauliflower"));
		itemMap.put(4, new Item(4, "honey"));
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doDelete(req, resp);
	}

	// GET /items
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO
		String id = req.getParameter("id");
		Integer key = null;
		if (id!= null) {
			key = Integer.valueOf(id.trim());
		}
		// there's almost certainly a better way to do this
		String payload = "{\n\"items\" : [";
		for (Item i : itemMap.values() ) {
			payload += i.getJson() + ",\n";
		}
		payload = payload.replaceAll(", $", "") + "]\n}";

		resp.getOutputStream().println(payload);
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPut(req, resp);
	}


}
