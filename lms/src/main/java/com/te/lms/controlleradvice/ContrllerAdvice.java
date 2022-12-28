//package com.te.lms.controlleradvice;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//
//import com.te.lms.appresponse.AppResponse;
//import com.te.lms.exception.DataNotFoundException;
//import com.te.lms.exception.InvalidPasswordException;
//import com.te.lms.exception.InvalidUserException;
//import com.te.lms.exception.NullInputException;
//import com.te.lms.exception.PasswordMistmatchException;
//
//@ControllerAdvice
//public class ContrllerAdvice {
//	@Autowired
//	AppResponse appResponse;
//
//	@ExceptionHandler(DataNotFoundException.class)
//	public Map<String, String> handlerException(DataNotFoundException notFoundException) {
//		Map<String, String> errorMap = new HashMap<>();
//		errorMap.put("errorMessage", notFoundException.getMessage());
//		return errorMap;
//	}
//
//	@ExceptionHandler(PasswordMistmatchException.class)
//	public Map<String, String> handlerException2(PasswordMistmatchException mistmatchException) {
//		Map<String, String> errorMap = new HashMap<>();
//		errorMap.put("errorMessage", mistmatchException.getMessage());
//		return errorMap;
//	}
//
//	@ExceptionHandler(InvalidUserException.class)
//	public Map<String, String> handlerException3(InvalidUserException userException) {
//		Map<String, String> errorMap = new HashMap<>();
//		errorMap.put("errorMessage", userException.getMessage());
//		return errorMap;
//	}
//
//	@ExceptionHandler(InvalidPasswordException.class)
//	public Map<String, String> handlerException4(InvalidPasswordException passwordException) {
//		Map<String, String> errorMap = new HashMap<>();
//		errorMap.put("errorMessage", passwordException.getMessage());
//		return errorMap;
//	}
//
//	@ExceptionHandler(NullInputException.class)
//	public ResponseEntity<AppResponse> nullInputException(InvalidUserException exception) {
//		appResponse.setStatus(604);
//		appResponse.setError(true);
//		appResponse.setMsg(NullInputException.exceptionMsg);
//
//		return new ResponseEntity<AppResponse>(appResponse, HttpStatus.BAD_REQUEST);
//	}
//
//	@ExceptionHandler(InvalidUserException.class)
//	public ResponseEntity<AppResponse> handleInvalidUserException(InvalidUserException exception) {
//		appResponse.setStatus(606);
//		appResponse.setError(true);
//		appResponse.setMsg("Inavlid feild");
//		return new ResponseEntity<AppResponse>(appResponse, HttpStatus.BAD_REQUEST);
//	}
//}

//@Autowired
//AppResponse appResponse;

//@ExceptionHandler(NullInputException.class)
//public ResponseEntity<AppResponse> nullInputException(InvalidUserException exception) {
//	appResponse.setStatus(604);
//	appResponse.setError(true);
//	appResponse.setMsg(NullInputException.exceptionMsg);
//
//	return new ResponseEntity<AppResponse>(appResponse, HttpStatus.BAD_REQUEST);
//}
//
//@ExceptionHandler(InvalidUserException.class)
//public ResponseEntity<AppResponse> handleInvalidUserException(InvalidUserException exception) {
//	appResponse.setStatus(606);
//	appResponse.setError(true);
//	appResponse.setMsg("Inavlid feild");
//
//	return new ResponseEntity<AppResponse>(appResponse, HttpStatus.BAD_REQUEST);
//}
//
//@ExceptionHandler(BatchEditException.class)
//public ResponseEntity<AppResponse> handleInvalidUserException(BatchEditException exception) {
//	appResponse.setStatus(605);
//	appResponse.setError(true);
//	appResponse.setMsg("Inavlid batch ID");
//	return new ResponseEntity<AppResponse>(appResponse, HttpStatus.BAD_REQUEST);
//}