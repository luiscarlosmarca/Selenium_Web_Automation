#language: es
#author: lmarinc

  Característica: Reporte diario de trabajo maxtime

  Antecedentes:
    Dado que LuisCa quiere loguearse en la aplicación de maxtime
    Cuando iniciar sesión



  # @Reportar hoy
  @Hoy
  Escenario: Reportar actividades de trabajo de hoy
    Cuando diligencia los datos necesarios para reportar
      |fecha|proyecto |tipoHora |servicio |actividad|horaEjecutada | comentario|diaHabil|
      |22/06/2019|GBCO24|H. Proyecto|P. generales CA CVDS ágiles|CAPACITACIÓN METODOLOGÍA DE PRUEBAS|8|Investigacion de automatizacion reto maxtime|false|
      |23/06/2019|GBCO24|H. Proyecto|P. generales CA CVDS ágiles|CAPACITACIÓN METODOLOGÍA DE PRUEBAS|8|Investigacion de automatizacion reto maxtime|false|
      |24/06/2019|GBCO24|H. Proyecto|P. generales CA CVDS ágiles|CAPACITACIÓN METODOLOGÍA DE PRUEBAS|8|Investigacion de automatizacion reto maxtime|false|
      |25/06/2019|GBCO24|H. Proyecto|P. generales CA CVDS ágiles|CAPACITACIÓN METODOLOGÍA DE PRUEBAS|8|Investigacion de automatizacion reto maxtime|true|
    Entonces la solicitud debe de quedar guardada correctamente

     # @ModificarDiasReportados
      @ModificarDiasReportados
      Escenario: Modificar reportes de dias anteriores
        Cuando diligencia los datos necesarios para modificar
          |fecha|proyecto |tipoHora |servicio |actividad|horaEjecutada | comentario|
          |22/06/2019|GBCO24|H. Proyecto|P. generales CA CVDS ágiles|CAPACITACIÓN METODOLOGÍA DE PRUEBAS|8|Investigacion de automatizacion reto maxtime|

        Entonces la solicitud debe de quedar modificada correctamente