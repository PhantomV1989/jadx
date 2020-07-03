package jadx.core.dex.visitors.methods;

import java.util.Collections;
import java.util.List;

import jadx.core.dex.info.MethodInfo;
import jadx.core.dex.instructions.args.ArgType;
import jadx.core.dex.nodes.GenericTypeParameter;
import jadx.core.dex.nodes.IMethodDetails;

public class MutableMethodDetails implements IMethodDetails {

	private final MethodInfo mthInfo;
	private ArgType retType;
	private List<ArgType> argTypes;
	private List<GenericTypeParameter> typeParams;
	private List<ArgType> throwTypes;
	private boolean varArg;

	public MutableMethodDetails(IMethodDetails base) {
		this.mthInfo = base.getMethodInfo();
		this.retType = base.getReturnType();
		this.argTypes = Collections.unmodifiableList(base.getArgTypes());
		this.typeParams = Collections.unmodifiableList(base.getTypeParameters());
		this.throwTypes = Collections.unmodifiableList(base.getThrows());
		this.varArg = base.isVarArg();
	}

	@Override
	public MethodInfo getMethodInfo() {
		return mthInfo;
	}

	@Override
	public ArgType getReturnType() {
		return retType;
	}

	@Override
	public List<ArgType> getArgTypes() {
		return argTypes;
	}

	@Override
	public List<GenericTypeParameter> getTypeParameters() {
		return typeParams;
	}

	@Override
	public List<ArgType> getThrows() {
		return throwTypes;
	}

	@Override
	public boolean isVarArg() {
		return varArg;
	}

	public void setRetType(ArgType retType) {
		this.retType = retType;
	}

	public void setArgTypes(List<ArgType> argTypes) {
		this.argTypes = argTypes;
	}

	public void setTypeParams(List<GenericTypeParameter> typeParams) {
		this.typeParams = typeParams;
	}

	public void setThrowTypes(List<ArgType> throwTypes) {
		this.throwTypes = throwTypes;
	}

	public void setVarArg(boolean varArg) {
		this.varArg = varArg;
	}

	@Override
	public String toString() {
		return "Mutable" + toAttrString();
	}
}
