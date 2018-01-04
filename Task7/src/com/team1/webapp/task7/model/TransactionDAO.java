package com.team1.webapp.task7.model;

import java.sql.Date;

import org.genericdao.ConnectionPool;
import org.genericdao.DAOException;
import org.genericdao.GenericDAO;
import org.genericdao.MatchArg;
import org.genericdao.RollbackException;

import com.team1.webapp.task7.databean.TransactionBean;

public class TransactionDAO extends GenericDAO<TransactionBean> {

	public TransactionDAO(ConnectionPool cp, String tableName)
			throws DAOException {
		super(TransactionBean.class, tableName, cp);
	}
	
	public TransactionBean[] getAllTransactions() throws RollbackException {
		TransactionBean[] transactions = match();
		if (transactions.length == 0) {
        	return null;
        }
		return transactions;
	}
	
	public TransactionBean[] getTransByCusId(int i) throws RollbackException {
		TransactionBean[] transactions = match(MatchArg.equals("customerid", i));
		if (transactions.length == 0) {
        	return null;
        }
		return transactions;
	}
	
	public Date getLastTradingDate(int customerid) throws RollbackException {
		 TransactionBean[] transactions = match(MatchArg.equals("customerid", customerid));
		 if (transactions.length == 0) {
	        	return null;
	        }
	    return transactions[transactions.length-1].getExecutedate();
	}
}
