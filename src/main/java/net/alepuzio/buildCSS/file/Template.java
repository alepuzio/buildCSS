package net.alepuzio.buildCSS.file;

import java.io.IOException;
import java.util.List;

import net.alepuzio.buildCSS.logic.element.row.RowCodeCSS;

public interface Template {

	public List<RowCodeCSS> code() throws IOException;
}