package com.hari;

import java.util.Date;

import org.hibernate.Session;

import com.hari.program.Program;
import com.hari.program.ProgramDetail;
import com.hari.dao.ProgramDao;

public class App {
	public static void main(String[] args) {

		try {
			Session session = ProgramDao.getSessionFactory().openSession();

			session.beginTransaction();

			for (int i = 0; i < 2; i++) {
				Program program = new Program();

				program.setProgramCode("EP223123" + i);
				program.setProgramDescription("Big Bang Theory - The Line Substitution Solution " + i);
				ProgramDetail pgmDetail = new ProgramDetail();
				pgmDetail.setCasts("Johnny Galecki, Jim Parsons, Kaley Cuoco - " + i);
				pgmDetail.setYear(2016);

				program.setProgramDetail(pgmDetail);
				pgmDetail.setProgram(program);

				session.save(program);
			}

			session.getTransaction().commit();
			
		} finally {
		}
		
	}
}