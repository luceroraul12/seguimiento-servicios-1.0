package directo;

import Datos.ServicioDAO;
import Datos.TablaDAO;
import domain.Servicio;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
class Borrador {

    private List<Servicio> mbtnMesCrearModificarEliminar = new ArrayList<>();

    @FXML
    private Button btnCargarMesFinal;

    @FXML
    private Button btnModificarMesFinal;

    @FXML
    private Button btnEliminarMesFinal;

    @FXML
    private GridPane gridOpciones;

    @FXML
    private Button btnCrearServicio;

    @FXML
    private Button btnCrearMes;

    @FXML
    private Button btnModificarServicio;

    @FXML
    private Button btnModificarMes;

    @FXML
    private Button btnEliminarServicio;

    @FXML
    private Button btnEliminarMes;

    @FXML
    private DatePicker calFechaMesGeneral;

    @FXML
    private Button clkImprimir;

    @FXML
    private Button clkVerMesGeneral;

    @FXML
    private GridPane entradaServicioEliminar;

    @FXML
    private Button btnCargarServicioEliminar;

    @FXML
    private TextField txtIdServicioServicioEliminar;

    @FXML
    private TextField txtNombreServicioServicioEliminar;

    @FXML
    private GridPane entradaServicioModificar;

    @FXML
    private Button btnCargarServicioModificar;

    @FXML
    private TextField txtIdServicioServicioModificar;

    @FXML
    private TextField txtNombreServicioServicioModificar;

    @FXML
    private TextField txtNombreNuevoServicioModificar;

    @FXML
    private GridPane entradaServicioCrear;

    @FXML
    private Button btnCargarServicioCrear;

    @FXML
    private TextField txtNombreServicioServicioCrear;

    @FXML
    private GridPane entradaMesCrearModificarEliminar;

    @FXML
    private DatePicker calFechaVencimientoMesCrearModificarEliminar;

    @FXML
    private DatePicker calFechaPagoMesCrearModificarEliminar;

    @FXML
    private TextField entradaCostoVencimientoMesCrearModificarEliminar;

    @FXML
    private TextField entradaCostoPagoMesCrearModificarEliminar;

    @FXML
    private Button btnCargarMes;

    @FXML
    private TextField txtIdServicioMesCrearModificar;

    @FXML
    private TextField txtNombreServicioMesCrearModificar;

    @FXML
    private Label lbLeyendaMesEspecifico;

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
    private TableColumn<Servicio, String> lbLeyendaServicios;

    @FXML
    private TableColumn<Servicio, Integer> clIdServicioServicios;

    @FXML
    private TableColumn<Servicio, String> clNombreServicioServicios;

    @FXML
    private TableView<Servicio> tablaMesServicio;

    @FXML
    private TableColumn<Servicio, String> lbLeyendaMesServicio;

    @FXML
    private TableColumn<Servicio, Integer> clIdServicioMesServicio;

    @FXML
    private TableColumn<Servicio, Integer> clIdMesMesServicio;

    @FXML
    private TableColumn<Servicio, LocalDate> clFechaVencimientoMesServicio;

    @FXML
    private TableColumn<Servicio, LocalDate> clFechaPagoMesServicio;

    @FXML
    private TableColumn<Servicio, Double> clCostoVencimientoMesServicio;

    @FXML
    private TableColumn<Servicio, Double> clCostoPagoMesServicio;

    @FXML
    private TableView<Servicio> tablaMesGeneral;

    @FXML
    private TableColumn<Servicio, String> lbLeyendaMesGeneral;

    @FXML
    private TableColumn<Servicio, Integer> clIdServicioMesGeneral;

    @FXML
    private TableColumn<Servicio, Integer> clIdMesMesGeneral;

    @FXML
    private TableColumn<Servicio, LocalDate> clFechaVencimientoMesGeneral;

    @FXML
    private TableColumn<Servicio, LocalDate> clFechaPagoMesGeneral;

    @FXML
    private TableColumn<Servicio, Double> clCostoVencimientoMesGeneral;

    @FXML
    private TableColumn<Servicio, Double> clCostoPagoMesGeneral;

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
    void clkCrearMes(ActionEvent event) {
        configuracionParaTablaMesesCrear();

    }

    @FXML
    void clkCrearServicio(ActionEvent event) {
        configuracionParaTablaServicios();
        configuracionParaCargarServicios();
    }

    @FXML
    void clkEliminarMes(ActionEvent event) {
        configuracionParaTablaMesesEliminar();

    }

    @FXML
    void clkEliminarServicio(ActionEvent event) {
        configuracionParaEliminarServicio();

    }

    @FXML
    void clkModificarMes(ActionEvent event) {
        configuracionParaTablaMesesModificar();

    }

    @FXML
    void clkModificarServicio(ActionEvent event) {
        configuracionParaTablaMesesModificar();

    }

    @FXML
    void clkServicioEliminar(ActionEvent event) {
        eliminarServicio();
    }

    @FXML
    void clkServicioModificar(ActionEvent event) {
        modificarServicio();
    }

    @FXML
    void seleccionarServicios(MouseEvent event) {
        seleccionarDeTablaServicio();
        cambiarTabla();
    }


    @FXML
    void clkCrearMesFinal(ActionEvent event) {
        crearMes();
    }

    @FXML
    void clkEliminarMesFinal(ActionEvent event) {

    }

    @FXML
    void clkModificarMesFinal(ActionEvent event) {

    }

    @FXML
    void clkSeleccionarMesServicio(MouseEvent event) {

    }

    @FXML
    void clkSeleccionarServiciosCargados(MouseEvent event) {

    }

    @FXML
    void clkSeleccionarServiciosFaltantes(MouseEvent event) {

    }

    @FXML
    void clkServicioCrear(ActionEvent event) {
        crearServicio();
    }


















    private void configuracionParaTablaServicios(){

        //para mostrar unicamente la seccion de crear servicios
        entradaServicioCrear.setVisible(true);
        entradaServicioEliminar.setVisible(false);
        entradaServicioModificar.setVisible(false);
        entradaMesCrearModificarEliminar.setVisible(false);
        tablaServicios.setVisible(true);
        tablaMesServicio.setVisible(false);
        tablaMesGeneral.setVisible(false);

        //Setear columnas
        clIdServicioServicios.setCellValueFactory(new PropertyValueFactory("idServicio"));
        clNombreServicioServicios.setCellValueFactory(new PropertyValueFactory("nombreServicio"));

        actualizarTablaServicios();

    }

    private void actualizarTablaServicios(){

        //uso de interfaces y conversion para obtener la lista a mostar
        ServicioDAO servicioDao = new ServicioDAO();
        List<Servicio> serviciosDisponibles = servicioDao.seleccionar();
        mbtnMesCrearModificarEliminar = serviciosDisponibles;
        ObservableList<Servicio> serviciosDisponiblesConvertidos = FXCollections.observableList(serviciosDisponibles);

        //agrego la lista a la tabla
        tablaServicios.setItems(serviciosDisponiblesConvertidos);

    }

    private void configuracionParaTablaMesesCrear(){
        //para mostrar unicamente la seccion de crear servicios
        entradaServicioCrear.setVisible(false);
        entradaServicioEliminar.setVisible(false);
        entradaServicioModificar.setVisible(false);
        entradaMesCrearModificarEliminar.setVisible(true);
        tablaServicios.setVisible(true);
        tablaMesServicio.setVisible(false);
        tablaMesGeneral.setVisible(false);
        btnCargarMesFinal.setVisible(true);
        btnModificarMesFinal.setVisible(false);
        btnEliminarMesFinal.setVisible(false);
        txtNombreServicioMesCrearModificar.setMouseTransparent(true);

        //Setear columnas
        clIdServicioServicios.setCellValueFactory(new PropertyValueFactory("idServicio"));
        clNombreServicioServicios.setCellValueFactory(new PropertyValueFactory("nombreServicio"));

        actualizarTablaServicios();
    }

    private void configuracionParaTablaMesesModificar(){
        //para mostrar unicamente la seccion de crear servicios
        entradaServicioCrear.setVisible(false);
        entradaServicioEliminar.setVisible(false);
        entradaServicioModificar.setVisible(false);
        entradaMesCrearModificarEliminar.setVisible(true);
        tablaServicios.setVisible(true);
        tablaMesServicio.setVisible(false);
        tablaMesGeneral.setVisible(false);
        btnCargarMesFinal.setVisible(false);
        btnModificarMesFinal.setVisible(true);
        btnEliminarMesFinal.setVisible(false);
        txtNombreServicioMesCrearModificar.setMouseTransparent(true);

        //Setear columnas
        clIdServicioServicios.setCellValueFactory(new PropertyValueFactory("idServicio"));
        clNombreServicioServicios.setCellValueFactory(new PropertyValueFactory("nombreServicio"));

        actualizarTablaServicios();
    }

    private void configuracionParaTablaMesesEliminar(){
        //para mostrar unicamente la seccion de crear servicios
        entradaServicioCrear.setVisible(false);
        entradaServicioEliminar.setVisible(false);
        entradaServicioModificar.setVisible(false);
        entradaMesCrearModificarEliminar.setVisible(true);
        tablaServicios.setVisible(true);
        tablaMesServicio.setVisible(false);
        tablaMesGeneral.setVisible(false);
        btnCargarMesFinal.setVisible(false);
        btnModificarMesFinal.setVisible(false);
        btnEliminarMesFinal.setVisible(true);
        txtNombreServicioMesCrearModificar.setMouseTransparent(true);

        //Setear columnas
        clIdServicioMesServicio.setCellFactory(new PropertyValueFactory("idServicio"));
        clIdMesMesServicio.setCellFactory(new PropertyValueFactory("idMensual"));
        clFechaVencimientoMesServicio.setCellFactory(new PropertyValueFactory("fechaVencimiento"));
        clFechaPagoMesServicio.setCellFactory(new PropertyValueFactory("fechaPago"));

        actualizarTablaServicios();
    }


    private void configuracionParaCargarServicios(){
        entradaMesCrearModificarEliminar.setVisible(false);
        entradaServicioEliminar.setVisible(false);
        entradaServicioModificar.setVisible(false);
        entradaServicioCrear.setVisible(true);
        entradaServicioCrear.setDisable(false);
    }

    private void configuracionParaModificarServicio(){
        entradaMesCrearModificarEliminar.setVisible(false);
        entradaServicioEliminar.setVisible(false);
        entradaServicioModificar.setVisible(true);
        entradaServicioCrear.setVisible(false);
    }

    private void configuracionParaEliminarServicio(){
        entradaMesCrearModificarEliminar.setVisible(false);
        entradaServicioEliminar.setVisible(true);
        entradaServicioModificar.setVisible(false);
        entradaServicioCrear.setVisible(false);
        entradaServicioEliminar.setDisable(false);
        tablaServicios.setVisible(true);

        clIdServicioServicios.setCellValueFactory(new PropertyValueFactory("idServicio"));
        clNombreServicioServicios.setCellValueFactory(new PropertyValueFactory("nombreServicio"));

        actualizarTablaServicios();

    }

    private void seleccionarDeTablaServicio(){

        Servicio servicioObtenido = tablaServicios.getSelectionModel().getSelectedItem();

        if (entradaServicioEliminar.isVisible()){
            txtIdServicioServicioEliminar.setText(String.valueOf(servicioObtenido.getIdServicio()));
            txtNombreServicioServicioEliminar.setText(servicioObtenido.getNombreServicio());
        }
        if (entradaServicioModificar.isVisible()){
            txtIdServicioServicioModificar.setText(String.valueOf(servicioObtenido.getIdServicio()));
            txtNombreServicioServicioModificar.setText(servicioObtenido.getNombreServicio());
        }
        if (entradaMesCrearModificarEliminar.isVisible()){
            txtNombreServicioMesCrearModificar.setText(servicioObtenido.getNombreServicio());
            txtIdServicioMesCrearModificar.setText(String.valueOf(servicioObtenido.getIdServicio()));
        }

    }

    private void crearServicio(){
        ServicioDAO servicioDao = new ServicioDAO();
        Servicio servicio = new Servicio(txtNombreServicioServicioCrear.getText());

        servicioDao.insertar(servicio);
        actualizarTablaServicios();
    }

    private void modificarServicio(){
        ServicioDAO servicioDao = new ServicioDAO();
        Servicio servicio = new Servicio(Integer.parseInt(txtIdServicioServicioModificar.getText()),txtNombreNuevoServicioModificar.getText());

        servicioDao.actualizar(servicio);

        actualizarTablaServicios();
    }

    private void eliminarServicio(){
        ServicioDAO servicioDao = new ServicioDAO();
        Servicio servicio = new Servicio(Integer.parseInt(txtIdServicioServicioEliminar.getText()));

        servicioDao.eliminar(servicio);

    }

    private void cambiarTabla(){
        if (entradaMesCrearModificarEliminar.isVisible()){
            tablaServicios.setVisible(false);
            tablaMesServicio.setVisible(true);
        }
    }

    private void crearMes(){
        int idServicio = Integer.parseInt(txtIdServicioMesCrearModificar.getText());
        LocalDate fechaVencimiento = calFechaVencimientoMesCrearModificarEliminar.getValue();
        LocalDate fechaPago = calFechaPagoMesCrearModificarEliminar.getValue();

        double costoVencimiento = Double.parseDouble(entradaCostoVencimientoMesCrearModificarEliminar.getText());
        double costoPago = Double.parseDouble(entradaCostoPagoMesCrearModificarEliminar.getText());

        Servicio servicio = new Servicio(idServicio, fechaVencimiento, fechaPago, costoVencimiento, costoPago);
        TablaDAO tablaDao = new TablaDAO();

        tablaDao.insertar(servicio);

        mostrarMesEspecifico(servicio);

    }

    private void mostrarMesEspecifico(Servicio servicio){

        //uso de interfaces y conversion para obtener la lista a mostar
        TablaDAO tablaDao = new TablaDAO();
        List<Servicio> serviciosFiltrados = tablaDao.seleccionar(servicio);
        mbtnMesCrearModificarEliminar = serviciosFiltrados;
        ObservableList<Servicio> serviciosDisponiblesConvertidos = FXCollections.observableList(serviciosFiltrados);

        //agrego la lista a la tabla
        tablaMesServicio.setItems(serviciosDisponiblesConvertidos);

    }
}
