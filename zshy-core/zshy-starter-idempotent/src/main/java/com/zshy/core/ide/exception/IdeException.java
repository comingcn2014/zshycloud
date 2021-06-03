package com.zshy.core.ide.exception;

/**
 * 幂等校验异常
 *
 * @author yanghaifeng
 */
public class IdeException extends RuntimeException {

	private static final long serialVersionUID = -851115183208290929L;

	public IdeException(String message) {
		super(message);
	}
}
