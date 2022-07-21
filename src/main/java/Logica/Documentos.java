package Logica;

import com.itextpdf.text.html.simpleparser.CellWrapper;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import domain.Servicio;
import javafx.collections.ObservableList;
import com.itextpdf.text.*;
import javafx.scene.control.Cell;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Documentos {


    public void crearPDF(ObservableList<Servicio> lista, String nombreArchivo){

        Document documento = new Document();
        String idMensual, nombreServicio, fechaVencimiento, fechaCosto, costoVencimiento, costoPago;
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/LL/yyyy");

        try {
            FileOutputStream ficheroPDF = new FileOutputStream(nombreArchivo+".pdf");

            PdfWriter.getInstance(documento, ficheroPDF);

            documento.open();


            Paragraph titulo = new Paragraph(nombreArchivo+"\n\n",
                    FontFactory.getFont("arial", 22, Font.BOLD, BaseColor.BLUE)
            );
            titulo.setAlignment(Element.ALIGN_CENTER);
            documento.add(titulo);

            PdfPTable tabla = new PdfPTable(6);

            tabla.setTotalWidth(500);
            tabla.setLockedWidth(true);
            tabla.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
            tabla.getDefaultCell().setVerticalAlignment(Element.ALIGN_CENTER);

            tabla.setWidths(new float[]{1, 5, 5, 5, 5, 5});

            tabla.addCell("ID");
            tabla.addCell("SERVICIO");
            tabla.addCell("FECHA VENCIMIENTO");
            tabla.addCell("FECHA PAGO");
            tabla.addCell("COSTO VENCIMIENTO");
            tabla.addCell("COSTO PAGO");

            for (Servicio x : lista){

                idMensual = Integer.toString(x.getIdMensual());
                nombreServicio = x.getNombreServicio();
                fechaVencimiento = x.getFechaVencimiento().format(formato);
                fechaCosto = x.getFechaPago().format(formato);
                costoVencimiento = Double.toString(x.getCostoVencimiento());
                costoPago = Double.toString(x.getCostoPago());


                tabla.addCell(idMensual);
                tabla.addCell(nombreServicio);
                tabla.addCell(fechaVencimiento);
                tabla.addCell(fechaCosto);
                tabla.addCell(costoVencimiento);
                tabla.addCell(costoPago);

            }

            documento.add(tabla);











            documento.close();

        } catch (FileNotFoundException | DocumentException e) {
            e.printStackTrace();
        }



    }

    private PdfPCell configurarCeldas(PdfPCell celda){

        celda.setVerticalAlignment(Element.ALIGN_CENTER);
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);

        return celda;
    }
}
