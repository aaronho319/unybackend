package app.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.entity.PurchaseOrder;
import app.repositories.PurchaseOrderRepository;

@Component
@Path("purchase-orders")
public class PurchaseOrderController {
	@Autowired
	private PurchaseOrderRepository purchaseOrderRepository;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<PurchaseOrder> index() {
		return purchaseOrderRepository.findAll();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void create(@FormParam("id") Long id, @FormParam("date") String date,
					   @FormParam("description") String description, @FormParam("quantity") Integer quantity,
					   @FormParam("sizeNumber") Integer sizeNumber, @FormParam("done") Boolean isDone) {
		PurchaseOrder purchaseOrder =  new PurchaseOrder(id, date, description, quantity, sizeNumber, isDone);
		purchaseOrderRepository.saveAndFlush(purchaseOrder);
	}
	
	@GET
    @Path("/{id}/show")
    @Produces(MediaType.APPLICATION_JSON)
    public PurchaseOrder show(@PathParam("id") Long id) {
        return purchaseOrderRepository.findOne(id);
    }

    @PUT
    @Path("/{id}/update")
    public void update(@PathParam("id") Long id, @FormParam("date") String date,
    				   @FormParam("description") String description, 
    				   @FormParam("quantity") Integer quantity, @FormParam("sizeNumber") Integer sizeNumber) {
    	PurchaseOrder purchaseOrder = purchaseOrderRepository.findOne(id);
    	purchaseOrder.setDate(date);
    	purchaseOrder.setDescription(description);
    	purchaseOrder.setQuantity(quantity);
    	purchaseOrder.setSize(sizeNumber);
    	purchaseOrderRepository.saveAndFlush(purchaseOrder);
    }
    
    @PUT
    @Path("/{id}/finish")
    public void finishOrder(@PathParam("id") Long id, @FormParam("done") Boolean isDone) {
    	PurchaseOrder purchaseOrder = purchaseOrderRepository.findOne(id);
    	purchaseOrder.setPurchaseOrderIsDone(isDone);
    	purchaseOrderRepository.saveAndFlush(purchaseOrder);
    }
    
    @DELETE
    @Path("/{id}/destroy")
    public void destroy(@PathParam("id") Long id){
    	purchaseOrderRepository.delete(id);
    }
}

  

