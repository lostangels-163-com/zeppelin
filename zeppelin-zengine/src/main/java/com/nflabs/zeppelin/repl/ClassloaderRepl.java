package com.nflabs.zeppelin.repl;

import java.util.Properties;

import com.nflabs.zeppelin.repl.ReplResult;

public class ClassloaderRepl extends Repl {

	private ClassLoader cl;
	private Repl repl;

	public ClassloaderRepl(Repl repl, ClassLoader cl, Properties property) {
		super(property);
		this.cl = cl;
		this.repl = repl;
	}
	
	public Repl getInnerRepl(){
		return repl;
	}

	@Override
	public Object getValue(String name) {
		ClassLoader oldcl = Thread.currentThread().getContextClassLoader();
		Thread.currentThread().setContextClassLoader(cl);
		try {
			return repl.getValue(name);
		} catch (Exception e){
			throw new ReplException(e);
		} finally {
			cl = Thread.currentThread().getContextClassLoader();
			Thread.currentThread().setContextClassLoader(oldcl);
		}
	}

	@Override
	public ReplResult interpret(String st) {
		ClassLoader oldcl = Thread.currentThread().getContextClassLoader();
		Thread.currentThread().setContextClassLoader(cl);
		try {
			return repl.interpret(st);
		} catch (Exception e){
			e.printStackTrace();
			throw new ReplException(e);
		} finally {
			cl = Thread.currentThread().getContextClassLoader();
			Thread.currentThread().setContextClassLoader(oldcl);
		}
	}

	@Override
	public void bindValue(String name, Object o) {
		ClassLoader oldcl = Thread.currentThread().getContextClassLoader();
		Thread.currentThread().setContextClassLoader(cl);
		try {
			repl.bindValue(name, o);
		} catch (Exception e){
			throw new ReplException(e);
		} finally {
			cl = Thread.currentThread().getContextClassLoader();
			Thread.currentThread().setContextClassLoader(oldcl);
		}
	}

	@Override
	public void initialize() {
		ClassLoader oldcl = Thread.currentThread().getContextClassLoader();
		Thread.currentThread().setContextClassLoader(cl);
		try {
			repl.initialize();
		} catch (Exception e){
			throw new ReplException(e);
		} finally {
			cl = Thread.currentThread().getContextClassLoader();
			Thread.currentThread().setContextClassLoader(oldcl);
		}		
	}

	@Override
	public void destroy() {
		ClassLoader oldcl = Thread.currentThread().getContextClassLoader();
		Thread.currentThread().setContextClassLoader(cl);
		try {
			repl.destroy();
		} catch (Exception e){
			throw new ReplException(e);
		} finally {
			cl = Thread.currentThread().getContextClassLoader();
			Thread.currentThread().setContextClassLoader(oldcl);
		}	
	}

	@Override
	public void cancel() {
		ClassLoader oldcl = Thread.currentThread().getContextClassLoader();
		Thread.currentThread().setContextClassLoader(cl);
		try {
			repl.cancel();
		} catch (Exception e){
			throw new ReplException(e);
		} finally {
			cl = Thread.currentThread().getContextClassLoader();
			Thread.currentThread().setContextClassLoader(oldcl);
		}	
	}

	@Override
	public FormType getFormType() {
		ClassLoader oldcl = Thread.currentThread().getContextClassLoader();
		Thread.currentThread().setContextClassLoader(cl);
		try {
			return repl.getFormType();
		} catch (Exception e){
			throw new ReplException(e);
		} finally {
			cl = Thread.currentThread().getContextClassLoader();
			Thread.currentThread().setContextClassLoader(oldcl);
		}	
	}
}
