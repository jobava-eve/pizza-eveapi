package moe.pizza.eveapi.endpoints

import moe.pizza.eveapi.{ApiRequest, ApiKey}
import moe.pizza.eveapi.generated.corp

import scala.concurrent.ExecutionContext

class Corp(baseurl: String, apikey: Option[ApiKey])(implicit ex: ExecutionContext) {
  def AccountBalance() = new ApiRequest[corp.AccountBalance.Eveapi](baseurl, "corp/AccountBalance.xml.aspx", apikey).apply().map{_.map{_.result.rowset.row}}
  def ContactList()  = new ApiRequest[corp.ContactList.Eveapi](baseurl, "corp/ContactList.xml.aspx", apikey).apply().map{_.map{_.result.rowset}}
  def Standings() = new ApiRequest[corp.Standings.Eveapi](baseurl, "corp/Standings.xml.aspx", apikey).apply().map{_.map{_.result.corporationNPCStandings.rowset}}
}
