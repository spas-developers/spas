package com.joelkingsley.rmkcet.spas.be.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.joelkingsley.rmkcet.spas.be.beans.Batch;
import com.joelkingsley.rmkcet.spas.be.constants.DBConstants;
import com.joelkingsley.rmkcet.spas.be.constants.DBQueries;
import com.joelkingsley.rmkcet.spas.be.constants.ErrorConstants;
import com.joelkingsley.rmkcet.spas.be.utils.AppError;
import com.joelkingsley.rmkcet.spas.be.utils.DBUtils;

public class BatchesDAO {
	public ArrayList<Batch> getAllBatches() throws AppError {
		Connection connection = DBUtils.getConnection();
		ArrayList<Batch> batches = new ArrayList<Batch>();
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(DBQueries.GET_ALL_BATCHES);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Batch batch = new Batch(
						resultSet.getInt(DBConstants.COL_BATCHES_BATCH_ID),
						resultSet.getInt(DBConstants.COL_BATCHES_BATCH_START_YEAR));
				
				batches.add(batch);
			}
			return batches;
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			throw new AppError(ErrorConstants.SERVER_ERROR);
		}
	}
	
	public boolean addBatch(Batch batch) throws AppError {
		Connection connection = DBUtils.getConnection();
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(DBQueries.ADD_BATCH);
			preparedStatement.setInt(1, batch.getBatchStartYear());
			int affectedRows = preparedStatement.executeUpdate();

			if (affectedRows >= 1) {
				return true;
			} else {
				return false;
			}
			
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			throw new AppError(ErrorConstants.SERVER_ERROR);
		}
	}

}
