package com.spring.pdf.format;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.spring.pdf.gen.model.User;

/**
 * This view class generates a PDF document 'on the fly' based on the data
 * contained in the model.
 * 
 * @author www.codejava.net
 *
 */
public class PDFBuilder extends AbstractITextPdfView {

	@SuppressWarnings("unchecked")
	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document doc,
			PdfWriter writer, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// get data model which is passed by the Spring container
		List<User> users = (List<User>) model.get("users");

		// Design ParaGraph

		Font blue = new Font(FontFamily.HELVETICA, 12, Font.BOLD,
				BaseColor.BLUE);
		Chunk blueText = new Chunk("Created By Basanta Kumar Hota :", blue);
		Paragraph p = new Paragraph(blueText);
		doc.add(p);
		/*// Added image in PDF
		Image img = Image
				.getInstance("C:/Users/basanta.kumar.hota/Desktop/download.jpg");
		img.scalePercent(100f);
		img.scaleAbsolute(120f, 60f);
		doc.add(img);*/
		PdfPTable table = new PdfPTable(6);
		table.setWidthPercentage(100.0f);
		table.setWidths(new float[] { 2.0f, 2.0f, 3.0f, 6.0f, 2.0f, 4.0f });
		table.setSpacingBefore(10);
		table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
		// define font for table header row
		Font font = FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(BaseColor.WHITE);

		// define table header cell
		PdfPCell cell = new PdfPCell(new Paragraph("Created By Basant"));
		/*
		 * previous code blue pattern cell.setBackgroundColor(BaseColor.BLUE);
		 * cell.setPadding(6);
		 */

		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setPadding(10.0f);
		cell.setBackgroundColor(new BaseColor(140, 221, 8));

		// write table header
		cell.setPhrase(new Phrase("USER-ID", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("NAME", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("MOBILE", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("@EMAIL-ID", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("AGE", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("ADDRESS", font));
		table.addCell(cell);

		// write table row data
		for (User user : users) {
			table.addCell(String.valueOf(user.getId()));
			table.addCell(user.getName());
			table.addCell(user.getMobileNo());
			table.addCell(user.getEmail());
			table.addCell(String.valueOf(user.getAge()));
			table.addCell(String.valueOf(user.getAddress()));
		}

		doc.add(table);

	}
}