package directo;

import Datos.ServicioDAO;
import Datos.TablaDAO;
import Logica.Costos;
import Logica.Documentos;
import Logica.Fechas;
import domain.Servicio;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.MotionBlur;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;

public class HelloController {

    @FXML
    private GridPane gridOpciones;

    @FXML
    private Button btnCambiarCrearServicio;

    @FXML
    private Button btnCambiarCrearMes;

    @FXML
    private Button btnCambiarModificarServicio;

    @FXML
    private Button btnCambiarModificarMes;

    @FXML
    private Button btnCambiarEliminarServicio;

    @FXML
    private Button btnCambiarEliminarMes;

    @FXML
    private DatePicker calFechaMesGeneral;

    @FXML
    private Button clkImprimir;

    @FXML
    private Button btnCambiarVerMesGeneral;

    @FXML
    private GridPane gridModificarServicio;

    @FXML
    private Button btnCargarModificarServicio;

    @FXML
    private TextField txtIdServicioModificarServicio;

    @FXML
    private TextField txtNombreViejoModificarServicio;

    @FXML
    private TextField txtNombreNuevoModificarServicio;

    @FXML
    private GridPane gridEliminarServicio;

    @FXML
    private Button btnCargarEliminarServicio;

    @FXML
    private TextField txtIdServicioEliminarServicio;

    @FXML
    private TextField txtNombreEliminarServicio;

    @FXML
    private GridPane gridCrearServicio;

    @FXML
    private Button btnCargarCrearServicio;

    @FXML
    private TextField txtNombreCrearServicio;

    @FXML
    private GridPane gridCrearMes;

    @FXML
    private DatePicker calFechaVencimientoCrearMes;

    @FXML
    private DatePicker calFechaPagoCrearMes;

    @FXML
    private TextField txtCostoVencimientoCrearMes;

    @FXML
    private TextField txtCostoPagoCrearMes;

    @FXML
    private Button btnCargarCrearMes;

    @FXML
    private TextField txtIdServicioCrearMes;

    @FXML
    private TextField txtNombreCrearMes;

    @FXML
    private GridPane gridModificarMes;

    @FXML
    private DatePicker calFechaVencimientoModificarMes;

    @FXML
    private DatePicker calFechaPagoModificarMes;

    @FXML
    private TextField txtCostoVencimientoModificarMes;

    @FXML
    private TextField calCostoPagoModificarMes;

    @FXML
    private Button btnCargarModificarMes;

    @FXML
    private TextField txtIdServicioModificarMes;

    @FXML
    private TextField txtNombreModificarMes;

    @FXML
    private TextField txtIdMesCrearMes;

    @FXML
    private GridPane gridEliminarMes;

    @FXML
    private DatePicker calFechaVencimientoEliminarMes;

    @FXML
    private DatePicker calFechaPagoEliminarMes;

    @FXML
    private TextField txtCostoVencimientoEliminarMes;

    @FXML
    private TextField txtCostoPagoEliminarMes;

    @FXML
    private Button btnCargarEliminarMes;

    @FXML
    private TextField txtIdServicioEliminarMes;

    @FXML
    private TextField txtNombreEliminarMes;

    @FXML
    private TextField txtIdMesEliminarMes;

    @FXML
    private Label lmLeyendaMesGeneral;

    @FXML
    private TableView<Servicio> tablaServiciosCargados;

    @FXML
    private TableColumn<Servicio, String> clServiciosCargados;

    @FXML
    private TableView<Servicio> tablaServiciosFaltantes;

    @FXML
    private TableColumn<Servicio, String> clServiciosFaltantes;

    @FXML
    private TableView<Servicio> tablaServicios;

    @FXML
    private TableColumn<Servicio, String> lbLeyendaTablaServicios;

    @FXML
    private TableColumn<Servicio, Integer> clmIdServicioTablaServicios;

    @FXML
    private TableColumn<Servicio, String> clmNombreTablaServicios;

    @FXML
    private TableView<Servicio> tablaMeses;

    @FXML
    private TableColumn<Servicio, String> lbLeyendaTablaMeses;

    @FXML
    private TableColumn<Servicio, Integer> clmIdServicioTablaMeses;

    @FXML
    private TableColumn<Servicio, Integer> clmIdMesTablaMeses;

    @FXML
    private TableColumn<Servicio, Locale> clmFechaVencimientoTablaMeses;

    @FXML
    private TableColumn<Servicio, Locale> clmFechaPagoTablaMeses;

    @FXML
    private TableColumn<Servicio, Double> clmCostoVencimientoTablaMeses;

    @FXML
    private TableColumn<Servicio, Double> clmCostoPagoTablaMeses;

    @FXML
    private GridPane gridFinal;

    @FXML
    private Label lbLeyendaVencimientoFinal;

    @FXML
    private Label lbCostoVencimientoFinal;

    @FXML
    private Label lbLeyendaPagoFinal;

    @FXML
    private Label lbcostoPagoFinal;

    @FXML
    private TableView<Servicio> tablaMesGeneral;

    @FXML
    private TableColumn<Servicio, String> lbLeyendaMesGeneral;

    @FXML
    private TableColumn<Servicio, String> clmNombreServicioMesGeneral;

    @FXML
    private TableColumn<Servicio, Integer> clmIdMesGeneral;

    @FXML
    private TableColumn<Servicio, DatePicker> clmFechaVencimientoMesGeneral;

    @FXML
    private TableColumn<Servicio, DatePicker> clmFechaPagoMesGeneral;

    @FXML
    private TableColumn<Servicio, Double> clmCostoVencimientoMesGeneral;

    @FXML
    private TableColumn<Servicio, Double> clmCostoPagoMesGeneral;









































































































    @FXML
    void clkCambiarCrearMes(ActionEvent event) {
        resetTodo();
        esFechaMesGeneralNula();
        cambiarCrearMes();
        actualizarTablaServicio();
        indicador();
    }

    @FXML
    void clkCambiarCrearServicio(ActionEvent event) {
        resetTodo();
        esFechaMesGeneralNula();
        cambiarCrearServicio();
        actualizarTablaServicio();

        indicador();
    }

    @FXML
    void clkCambiarEliminarMes(ActionEvent event) {
        resetTodo();
        esFechaMesGeneralNula();
        cambiarEliminarMes();
        actualizarTablaServicio();
        indicador();
    }

    @FXML
    void clkCambiarEliminarServicio(ActionEvent event) {
        resetTodo();
        esFechaMesGeneralNula();
        cambiarEliminarServicio();
        actualizarTablaServicio();
        indicador();
    }

    @FXML
    void clkCambiarModificarMes(ActionEvent event) {
        resetTodo();
        esFechaMesGeneralNula();
        cambiarModificarMes();
        actualizarTablaServicio();
        indicador();
    }

    @FXML
    void clkCambiarModificarServicio(ActionEvent event) {
        resetTodo();
        esFechaMesGeneralNula();
        cambiarModificarServicio();
        actualizarTablaServicio();
        indicador();
    }

    @FXML
    void clkCambiarVerMesGeneral(ActionEvent event) {

        esFechaMesGeneralNula();

        cambiarTablaMesGeneral();

        obtenerActualizarCargadosFaltantes();

        configurarTablaMesGeneral();

        actualizarTablaMesGeneral();

        configurarGridFinal();
        indicador();
    }

    @FXML
    void clkCargarCrearMes(ActionEvent event) {
        cargarMes(mesCreado());
        actualizarTablaMeses();

        obtenerActualizarCargadosFaltantes();
        resetTodo();

        resetTodo();
    }

    @FXML
    void clkCargarCrearServicio(ActionEvent event) {
        cargarServicio(servicioCreado());
        actualizarTablaServicio();

        resetTodo();
    }

    @FXML
    void clkCargarEliminarMes(ActionEvent event) {
        cargarMes(mesEliminado());
        actualizarTablaMeses();

        obtenerActualizarCargadosFaltantes();

        resetTodo();
    }

    @FXML
    void clkCargarEliminarServicio(ActionEvent event) {
        cargarServicio(servicioEliminado());
        actualizarTablaServicio();

        resetTodo();
    }

    @FXML
    void clkCargarModificarMes(ActionEvent event) {
        cargarMes(mesModificado());
        actualizarTablaMeses();

        resetTodo();
    }

    @FXML
    void clkCargarModificarServicio(ActionEvent event) {
        cargarServicio(servicioModificado());
        actualizarTablaServicio();

        actualizarMesGeneral();

        resetTodo();
    }

    @FXML
    void clkImprimir(ActionEvent event) {
        esFechaMesGeneralNula();

        cargarDocumento();
    }

    @FXML
    void clkSeleccionarServiciosCargados(MouseEvent event) {

    }

    @FXML
    void selecTablaMeses(MouseEvent event) {
        obtenerSelecTablaMeses();
    }

    @FXML
    void selecTablaServicios(MouseEvent event) {
        obtenerSelecTablaServicios();
    }

    @FXML
    void selecTablaServiciosFaltantes(MouseEvent event) {

    }





























































































    private void cambiarCrearServicio(){

        gridCrearMes.setVisible(false);
        gridModificarMes.setVisible(false);
        gridEliminarMes.setVisible(false);
        gridCrearServicio.setVisible(true);
        gridModificarServicio.setVisible(false);
        gridEliminarServicio.setVisible(false);

        tablaMeses.setVisible(false);
        tablaServicios.setVisible(true);
        tablaMesGeneral.setVisible(false);


        configurarTablaServicios();

    }

    private void cambiarModificarServicio(){

        gridCrearMes.setVisible(false);
        gridModificarMes.setVisible(false);
        gridEliminarMes.setVisible(false);
        gridCrearServicio.setVisible(false);
        gridModificarServicio.setVisible(true);
        gridEliminarServicio.setVisible(false);

        tablaMeses.setVisible(false);
        tablaServicios.setVisible(true);
        tablaMesGeneral.setVisible(false);


        configurarTablaServicios();

    }

    private void cambiarEliminarServicio(){

        gridCrearMes.setVisible(false);
        gridModificarMes.setVisible(false);
        gridEliminarMes.setVisible(false);
        gridCrearServicio.setVisible(false);
        gridModificarServicio.setVisible(false);
        gridEliminarServicio.setVisible(true);

        tablaMeses.setVisible(false);
        tablaServicios.setVisible(true);
        tablaMesGeneral.setVisible(false);


        configurarTablaServicios();

    }

    private void cambiarCrearMes(){

        gridCrearMes.setVisible(true);
        gridModificarMes.setVisible(false);
        gridEliminarMes.setVisible(false);
        gridCrearServicio.setVisible(false);
        gridModificarServicio.setVisible(false);
        gridEliminarServicio.setVisible(false);

        tablaMeses.setVisible(false);
        tablaServicios.setVisible(true);
        tablaMesGeneral.setVisible(false);


        configurarTablaServicios();

    }

    private void cambiarModificarMes(){
        gridCrearMes.setVisible(false);
        gridModificarMes.setVisible(true);
        gridEliminarMes.setVisible(false);
        gridCrearServicio.setVisible(false);
        gridModificarServicio.setVisible(false);
        gridEliminarServicio.setVisible(false);

        tablaMeses.setVisible(false);
        tablaServicios.setVisible(true);
        tablaMesGeneral.setVisible(false);


        configurarTablaServicios();

    }

    private void cambiarEliminarMes(){

        gridCrearMes.setVisible(false);
        gridModificarMes.setVisible(false);
        gridEliminarMes.setVisible(true);
        gridCrearServicio.setVisible(false);
        gridModificarServicio.setVisible(false);
        gridEliminarServicio.setVisible(false);

        tablaMeses.setVisible(false);
        tablaServicios.setVisible(true);
        tablaMesGeneral.setVisible(false);

        configurarTablaServicios();

    }

    private void cambiarTablaMesGeneral(){
        gridCrearMes.setVisible(false);
        gridModificarMes.setVisible(false);
        gridEliminarMes.setVisible(false);
        gridCrearServicio.setVisible(false);
        gridModificarServicio.setVisible(false);
        gridEliminarServicio.setVisible(false);

        tablaMeses.setVisible(false);
        tablaServicios.setVisible(false);
        tablaMesGeneral.setVisible(true);

    }

    private void configurarTablaServicios(){
        clmIdServicioTablaServicios.setCellValueFactory(new PropertyValueFactory("idServicio"));
        clmNombreTablaServicios.setCellValueFactory(new PropertyValueFactory("nombreServicio"));
    }

    private void configurarTablaMeses(){
        clmIdServicioTablaMeses.setCellValueFactory(new PropertyValueFactory("idServicio"));
        clmIdMesTablaMeses.setCellValueFactory(new PropertyValueFactory("idMensual"));
        clmFechaVencimientoTablaMeses.setCellValueFactory(new PropertyValueFactory("fechaVencimiento"));
        clmFechaPagoTablaMeses.setCellValueFactory(new PropertyValueFactory("fechaPago"));
        clmCostoVencimientoTablaMeses.setCellValueFactory(new PropertyValueFactory("costoVencimiento"));
        clmCostoPagoTablaMeses.setCellValueFactory(new PropertyValueFactory("costoPago"));
    }

    private void configurarTablaCargadoFaltantes(){
        clServiciosCargados.setCellValueFactory(new PropertyValueFactory("nombreServicio"));
        clServiciosFaltantes.setCellValueFactory(new PropertyValueFactory("nombreServicio"));
    }

    private void configurarTablaMesGeneral(){
        clmNombreServicioMesGeneral.setCellValueFactory(new PropertyValueFactory("nombreServicio"));
        clmIdMesGeneral.setCellValueFactory(new PropertyValueFactory("idMensual"));
        clmFechaVencimientoMesGeneral.setCellValueFactory(new PropertyValueFactory("fechaVencimiento"));
        clmFechaPagoMesGeneral.setCellValueFactory(new PropertyValueFactory("fechaPago"));
        clmCostoVencimientoMesGeneral.setCellValueFactory(new PropertyValueFactory("costoVencimiento"));
        clmCostoPagoMesGeneral.setCellValueFactory(new PropertyValueFactory("costoPago"));

        lbLeyendaMesGeneral.setText("SERVICIOS CARGADOS "+lmLeyendaMesGeneral.getText());

        configurarTablaCargadoFaltantes();
    }

    private void cambiarTablaServiciosPorTablaMeses(){
        tablaServicios.setVisible(false);
        tablaMeses.setVisible(true);

        configurarTablaMeses();
    }

    private void configurarGridFinal(){
        Costos costos = new Costos();

        ObservableList<Servicio> listaServiciosMostrados = tablaMesGeneral.getItems();
        List<Servicio> listaConvertida = listaServiciosMostrados.stream().toList();

        double costoVencimientoFinal = costos.costoVencimientoFinal(listaConvertida);
        double costoPagoFinal = costos.costoPagoFinal(listaConvertida);

        DecimalFormat formato = new DecimalFormat("000,000.00");

        lbCostoVencimientoFinal.setText(formato.format(costoVencimientoFinal));
        lbcostoPagoFinal.setText(formato.format(costoPagoFinal));


        gridFinal.setVisible(true);


    }

    private void personalizarTablaMeses(String servicio){
        lbLeyendaTablaMeses.setText("BOLETAS CARGADAS DE "+servicio.toUpperCase(Locale.ROOT));
    }


    private Servicio servicioCreado(){
        String nombreServicio = txtNombreCrearServicio.getText();
        return new Servicio(nombreServicio);
    }

    private Servicio servicioModificado(){
        int idServicio = Integer.parseInt(txtIdServicioModificarServicio.getText());
        String nombreModificado = txtNombreNuevoModificarServicio.getText();

        return new Servicio(idServicio, nombreModificado);
    }

    private Servicio servicioEliminado(){
        int idServicio = Integer.parseInt(txtIdServicioEliminarServicio.getText());

        return new Servicio(idServicio);
    }

    private Servicio mesCreado(){
        int idServicio, idMensual;
        LocalDate fechaVencimiento, fechaPago;
        Double costoVencimiento, costoPago;

        idServicio = Integer.parseInt(txtIdServicioCrearMes.getText());
        fechaVencimiento = calFechaVencimientoCrearMes.getValue();
        fechaPago = calFechaPagoCrearMes.getValue();
        costoVencimiento = Double.parseDouble(txtCostoVencimientoCrearMes.getText());
        costoPago = Double.parseDouble(txtCostoPagoCrearMes.getText());

        return new Servicio(idServicio, fechaVencimiento, fechaPago, costoVencimiento, costoPago);
    }

    private Servicio mesModificado(){
        int idServicio, idMensual;
        LocalDate fechaVencimiento, fechaPago;
        Double costoVencimiento, costoPago;

        idServicio = Integer.parseInt(txtIdServicioModificarMes.getText());
        idMensual = Integer.parseInt(txtIdMesCrearMes.getText());
        fechaVencimiento = calFechaVencimientoModificarMes.getValue();
        fechaPago = calFechaPagoModificarMes.getValue();
        costoVencimiento = Double.parseDouble(txtCostoVencimientoModificarMes.getText());
        costoPago = Double.parseDouble(calCostoPagoModificarMes.getText());

        return new Servicio(idServicio, idMensual, fechaVencimiento, fechaPago, costoVencimiento, costoPago);
    }

    private Servicio mesEliminado(){
        int idServicio, idMensual;

        idServicio = Integer.parseInt(txtIdServicioEliminarMes.getText());
        idMensual = Integer.parseInt(txtIdMesEliminarMes.getText());
        return new Servicio(idServicio, idMensual);
    }

    private void cargarServicio(Servicio servicio){

        ServicioDAO servicioDao = new ServicioDAO();
        TablaDAO tablaDao = new TablaDAO();

        if (gridCrearServicio.isVisible()){

            servicioDao.insertar(servicio);

        }

        if (gridModificarServicio.isVisible()){

            servicioDao.actualizar(servicio);

        }

        if (gridEliminarServicio.isVisible()){

            servicioDao.eliminar(servicio);
            tablaDao.eliminarWhere(servicio);
        }

    }

    private void cargarMes(Servicio servicio){
        TablaDAO tablaDao = new TablaDAO();

        if (gridCrearMes.isVisible()){
            tablaDao.insertar(servicio);
        }
        if (gridModificarMes.isVisible()){
            tablaDao.actualizar(servicio);
        }
        if (gridEliminarMes.isVisible()){
            tablaDao.eliminar(servicio);
        }
    }

    private void actualizarTablaServicio(){

        if (!gridCrearServicio.isVisible()){
            lbLeyendaTablaServicios.setText("SERVICIOS DISPONIBLES");
        }
        ServicioDAO servicioDao = new ServicioDAO();
        List<Servicio> serviciosDisponibles = servicioDao.seleccionar();
        ObservableList<Servicio> serviciosDisponiblesConvertidos = FXCollections.observableList(serviciosDisponibles);

        tablaServicios.setItems(serviciosDisponiblesConvertidos);

    }

    private void actualizarTablaMeses(){

        Servicio servicioElegido;
        int idServicio = 0;

        if (gridCrearMes.isVisible()){
            idServicio = Integer.parseInt(txtIdServicioCrearMes.getText());
        }
        if (gridModificarMes.isVisible()){
            idServicio = Integer.parseInt(txtIdServicioModificarMes.getText());
        }
        if (gridEliminarMes.isVisible()){
            idServicio = Integer.parseInt(txtIdServicioEliminarMes.getText());
        }

        servicioElegido = new Servicio(idServicio);
        TablaDAO tablaDao = new TablaDAO();
        List<Servicio> serviciosFiltrados = tablaDao.seleccionar(servicioElegido);
        ObservableList<Servicio> serviciosFiltradosConvertidos = FXCollections.observableList(serviciosFiltrados);

        tablaMeses.setItems(serviciosFiltradosConvertidos);

    }

    private void actualizarMesGeneral(){

        Fechas fecha = new Fechas();

        esFechaMesGeneralNula();

        List<Servicio> serviciosParaMostarMesGeneral = fecha.serviciosCargadosMesGeneral(calFechaMesGeneral.getValue());

        System.out.println(serviciosParaMostarMesGeneral);

        ObservableList<Servicio> serviciosConvertidos = FXCollections.observableList(serviciosParaMostarMesGeneral);

        tablaMeses.setItems(serviciosConvertidos);

    }

    private void actualizarTablaMesGeneral(){

        Fechas fecha = new Fechas();

        esFechaMesGeneralNula();

        List<Servicio> serviciosParaMostarMesGeneral = fecha.serviciosCargadosMesGeneral(calFechaMesGeneral.getValue());

        System.out.println(serviciosParaMostarMesGeneral);

        ObservableList<Servicio> serviciosConvertidos = FXCollections.observableList(serviciosParaMostarMesGeneral);

        tablaMesGeneral.setItems(serviciosConvertidos);


    }

    private void obtenerSelecTablaServicios(){
        Servicio servicioSeleccionado = tablaServicios.getSelectionModel().getSelectedItem();

        int idServicio = servicioSeleccionado.getIdServicio();
        int idMensual = servicioSeleccionado.getIdMensual();
        String nombreServicio = servicioSeleccionado.getNombreServicio();

        if (gridModificarServicio.isVisible()){

            txtIdServicioModificarServicio.setText(Integer.toString(idServicio));
            txtNombreViejoModificarServicio.setText(nombreServicio);
        }

        if (gridEliminarServicio.isVisible()){

            txtIdServicioEliminarServicio.setText(Integer.toString(idServicio));
            txtNombreEliminarServicio.setText(nombreServicio);
        }

        if (gridCrearMes.isVisible()){
            txtIdServicioCrearMes.setText(Integer.toString(idServicio));
            txtNombreCrearMes.setText(nombreServicio);

            cambiarTablaServiciosPorTablaMeses();
            actualizarTablaMeses();
            modificarNombreTablaMeses();
            personalizarTablaMeses(nombreServicio);

        }

        if (gridModificarMes.isVisible()){
            txtIdServicioModificarMes.setText(Integer.toString(idServicio));
            txtNombreModificarMes.setText(nombreServicio);
            txtIdMesCrearMes.setText(Integer.toString(idMensual));

            cambiarTablaServiciosPorTablaMeses();
            actualizarTablaMeses();
            modificarNombreTablaMeses();
            personalizarTablaMeses(nombreServicio);
        }

        if (gridEliminarMes.isVisible()){
            txtIdServicioEliminarMes.setText(Integer.toString(idServicio));
            txtNombreEliminarMes.setText(nombreServicio);
            txtIdMesEliminarMes.setText(Integer.toString(idMensual));

            cambiarTablaServiciosPorTablaMeses();
            actualizarTablaMeses();
            modificarNombreTablaMeses();
            personalizarTablaMeses(nombreServicio);
        }


    }

    private void modificarNombreTablaMeses(){

        Servicio servicioSeleccionado = tablaServicios.getSelectionModel().getSelectedItem();
        String nombreServicio = servicioSeleccionado.getNombreServicio();


    }

    private void obtenerSelecTablaMeses(){
        Servicio servicioSeleccionado = tablaMeses.getSelectionModel().getSelectedItem();

        int idServicio = servicioSeleccionado.getIdServicio();
        int idMes = servicioSeleccionado.getIdMensual();
        String nombreServicio = servicioSeleccionado.getNombreServicio();
        LocalDate fechaVencimiento = servicioSeleccionado.getFechaVencimiento();
        LocalDate fechaPago = servicioSeleccionado.getFechaPago();
        Double costoVencimiento = servicioSeleccionado.getCostoVencimiento();
        Double costoPago = servicioSeleccionado.getCostoPago();

        if (gridModificarMes.isVisible()){
            txtIdServicioModificarMes.setText(Integer.toString(idServicio));
            txtIdMesCrearMes.setText(Integer.toString(idMes));
            calFechaVencimientoModificarMes.setValue(fechaVencimiento);
            calFechaPagoModificarMes.setValue(fechaPago);
            txtCostoVencimientoModificarMes.setText(costoVencimiento.toString());
            calCostoPagoModificarMes.setText(costoPago.toString());
        }

        if (gridEliminarMes.isVisible()){

            txtIdServicioEliminarMes.setText(Integer.toString(idServicio));
            txtIdMesEliminarMes.setText(Integer.toString(idMes));
            calFechaVencimientoEliminarMes.setValue(fechaVencimiento);
            calFechaPagoEliminarMes.setValue(fechaPago);
            txtCostoVencimientoEliminarMes.setText(costoVencimiento.toString());
            txtCostoPagoEliminarMes.setText(costoPago.toString());
        }
    }

    private void cambiarLeyendaCargadoFaltantes(){

        esFechaMesGeneralNula();

        LocalDate fechaElegida = calFechaMesGeneral.getValue();
        String mesElegido = fechaElegida.getMonth().getDisplayName(TextStyle.FULL, new Locale("es", "AR"));
        int añoElegido = fechaElegida.getYear();
        lmLeyendaMesGeneral.setText(mesElegido.toUpperCase(Locale.ROOT)+" DEL "+añoElegido);

    }

    private void obtenerActualizarCargadosFaltantes(){

        Fechas fechas = new Fechas();
        List<Servicio> serviciosCargados = fechas.serviciosCargadosMesGeneral(calFechaMesGeneral.getValue());
        List<Servicio> serviciosFaltantes = fechas.serviciosSinCargarMesActual(serviciosCargados);

        ObservableList<Servicio> serviciosCargadosConvertidos = FXCollections.observableList(serviciosCargados);
        ObservableList<Servicio> serviciosFaltantesConvertidos = FXCollections.observableList(serviciosFaltantes);

        tablaServiciosCargados.setItems(serviciosCargadosConvertidos);
        tablaServiciosFaltantes.setItems(serviciosFaltantesConvertidos);

        cambiarLeyendaCargadoFaltantes();

    }

    private void esFechaMesGeneralNula(){

        if (calFechaMesGeneral.getValue() == null){

            calFechaMesGeneral.setValue(LocalDate.now());

        }

    }

    private void indicador(){

        boolean esTodoOculto = !gridCrearServicio.isVisible() & !gridModificarServicio.isVisible() & !gridEliminarServicio.isVisible() & !gridCrearMes.isVisible() & !gridModificarMes.isVisible() & !gridEliminarMes.isVisible();

        MotionBlur motionBlur = new MotionBlur();
        motionBlur.setRadius(7);
        motionBlur.setAngle(20);



        if (gridCrearServicio.isVisible()){
            btnCambiarModificarServicio.setEffect(motionBlur);
            btnCambiarEliminarServicio.setEffect(motionBlur);
            btnCambiarCrearMes.setEffect(motionBlur);
            btnCambiarModificarMes.setEffect(motionBlur);
            btnCambiarEliminarMes.setEffect(motionBlur);
        }

        if (gridModificarServicio.isVisible()){
            btnCambiarCrearServicio.setEffect(motionBlur);
            btnCambiarEliminarServicio.setEffect(motionBlur);
            btnCambiarCrearMes.setEffect(motionBlur);
            btnCambiarModificarMes.setEffect(motionBlur);
            btnCambiarEliminarMes.setEffect(motionBlur);
        }

        if (gridEliminarServicio.isVisible()){
            btnCambiarCrearServicio.setEffect(motionBlur);
            btnCambiarModificarServicio.setEffect(motionBlur);
            btnCambiarCrearMes.setEffect(motionBlur);
            btnCambiarModificarMes.setEffect(motionBlur);
            btnCambiarEliminarMes.setEffect(motionBlur);
        }

        if (gridCrearMes.isVisible()){
            btnCambiarCrearServicio.setEffect(motionBlur);
            btnCambiarModificarServicio.setEffect(motionBlur);
            btnCambiarEliminarServicio.setEffect(motionBlur);
            btnCambiarModificarMes.setEffect(motionBlur);
            btnCambiarEliminarMes.setEffect(motionBlur);
        }

        if (gridModificarMes.isVisible()){
            btnCambiarCrearServicio.setEffect(motionBlur);
            btnCambiarModificarServicio.setEffect(motionBlur);
            btnCambiarEliminarServicio.setEffect(motionBlur);
            btnCambiarCrearMes.setEffect(motionBlur);
            btnCambiarEliminarMes.setEffect(motionBlur);
        }

        if (gridEliminarMes.isVisible()){
            btnCambiarCrearServicio.setEffect(motionBlur);
            btnCambiarModificarServicio.setEffect(motionBlur);
            btnCambiarEliminarServicio.setEffect(motionBlur);
            btnCambiarCrearMes.setEffect(motionBlur);
            btnCambiarModificarMes.setEffect(motionBlur);
        }

        if (esTodoOculto){

            btnCambiarCrearServicio.setEffect(motionBlur);
            btnCambiarModificarServicio.setEffect(motionBlur);
            btnCambiarEliminarServicio.setEffect(motionBlur);
            btnCambiarCrearMes.setEffect(motionBlur);
            btnCambiarModificarMes.setEffect(motionBlur);
            btnCambiarEliminarMes.setEffect(motionBlur);

        }




    }

    private void resetBotonesSinEfectos(){

        btnCambiarCrearServicio.setEffect(null);
        btnCambiarModificarServicio.setEffect(null);
        btnCambiarEliminarServicio.setEffect(null);
        btnCambiarCrearMes.setEffect(null);
        btnCambiarModificarMes.setEffect(null);
        btnCambiarEliminarMes.setEffect(null);

    }

    private void resetTodo(){
        txtNombreCrearMes.setText("");
        txtIdMesCrearMes.setText("");
        txtIdServicioCrearMes.setText("");
        txtCostoPagoCrearMes.setText("");
        txtCostoVencimientoCrearMes.setText("");
        calFechaVencimientoCrearMes.getEditor().clear();
        calFechaPagoCrearMes.getEditor().clear();

        txtNombreModificarMes.setText("");
        txtCostoVencimientoModificarMes.setText("");
        txtIdServicioModificarMes.setText("");
        calCostoPagoModificarMes.setText("");
        calFechaPagoModificarMes.getEditor().clear();
        calFechaVencimientoModificarMes.getEditor().clear();

        txtNombreEliminarMes.setText("");
        txtIdMesEliminarMes.setText("");
        txtIdServicioEliminarMes.setText("");
        txtCostoPagoEliminarMes.setText("");
        txtCostoVencimientoEliminarMes.setText("");
        calFechaVencimientoEliminarMes.getEditor().clear();
        calFechaPagoEliminarMes.getEditor().clear();

        txtNombreCrearServicio.setText("");

        txtNombreViejoModificarServicio.setText("");
        txtIdServicioModificarServicio.setText("");
        txtNombreNuevoModificarServicio.setText("");

        txtNombreEliminarServicio.setText("");
        txtIdServicioEliminarServicio.setText("");

        gridFinal.setVisible(false);

        resetBotonesSinEfectos();

        lbLeyendaTablaServicios.setText("SERVICIOS DISPONIBLES");

    }

    private void cargarDocumento(){

        Documentos documentos = new Documentos();

        documentos.crearPDF(tablaMesGeneral.getItems(), lmLeyendaMesGeneral.getText());

    }
































}
