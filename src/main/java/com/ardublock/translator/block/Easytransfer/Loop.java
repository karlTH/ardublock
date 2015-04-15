package com.ardublock.translator.block.Easytransfer;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class Loop extends TranslatorBlock
{

	public Loop(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
	{
		super(blockId, translator, codePrefix, codeSuffix, label);
	}

	@Override
	public String toCode() throws SocketNullException, SubroutineNotDeclaredException
	{
		String ret;
		translator.addSetupCommand("Serial.begin(9600);");
		translator.addSetupCommand("ET.begin(details(mydata), &Serial);");
		
		ret = "#include <EasyTransfer.h>\n\nEasyTransfer ET;\n\nstruct DATA_STRUCTURE{\n";
		
		TranslatorBlock translatorBlock = getTranslatorBlockAtSocket(0);
		while (translatorBlock != null)
		{
			
			ret = ret + translatorBlock.toCode();
			translatorBlock = translatorBlock.nextTranslatorBlock();
			
		}
		
		ret = ret + "};\n\nDATA_STRUCTURE mydata;\n\n";
		translator.addDefinitionCommand(ret);
		return  null ;
	}

}
