package com.ardublock.translator.block.Easytransfer;



import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class Receive_variable extends TranslatorBlock
{
	
	public Receive_variable(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
	{
		super(blockId, translator, codePrefix, codeSuffix, label);
	}

	@Override
	public String toCode() throws SocketNullException, SubroutineNotDeclaredException
	{
		TranslatorBlock tb = this.getRequiredTranslatorBlockAtSocket(0);
		String Variable = tb.toCode();
				
		
		String  ret= "mydata."+Variable.replace("\"","");
		  
		  
		return codePrefix + ret + codeSuffix;
	}

}
