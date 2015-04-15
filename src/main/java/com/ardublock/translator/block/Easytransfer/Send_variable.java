package com.ardublock.translator.block.Easytransfer;



import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class Send_variable extends TranslatorBlock
{
	
	public Send_variable(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
	{
		super(blockId, translator, codePrefix, codeSuffix, label);
	}

	@Override
	public String toCode() throws SocketNullException, SubroutineNotDeclaredException
	{
		TranslatorBlock tb = this.getRequiredTranslatorBlockAtSocket(0);
		String Variable = tb.toCode();
		tb = this.getRequiredTranslatorBlockAtSocket(1);
		String Valeur = tb.toCode();
		
		
		String  ret= "mydata."+Variable.replace("\"","")+" = "+Valeur+";\nET.sendData();";
		  
		  
		return ret;
	}

}
