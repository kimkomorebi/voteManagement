package vote;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DBExpert;
import model.VoteMember;

/**
 * Servlet implementation class putVoteServlet
 */
@WebServlet("/putVote.do")
public class putVoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public putVoteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String v_jumin = request.getParameter("V_JUMIN");
		String v_name = request.getParameter("V_NAME");
		String m_no = request.getParameter("M_NO");
		String v_time = request.getParameter("V_TIME");
		String v_area = request.getParameter("V_AREA");
		String v_confirm = request.getParameter("V_CONFIRM");
		VoteMember vm = new VoteMember();
		vm.setV_jumin(v_jumin);
		vm.setV_name(v_name);
		vm.setM_no(m_no);
		vm.setV_time(v_time);
		vm.setV_area(v_area);
		vm.setV_confirm(v_confirm);
		DBExpert dbe = new DBExpert();
		boolean result = dbe.putVoteInfo(vm);
		if(result) {
			response.sendRedirect("putVoteResult.jsp?R=Y");
		}else {
			response.sendRedirect("putVoteResult.jsp?R=N");
		}
		
	}

}
