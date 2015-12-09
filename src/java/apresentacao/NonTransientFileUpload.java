/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apresentacao;

/**
 *
 * @author guto
 */
public class NonTransientFileUpload extends org.primefaces.component.fileupload.FileUpload {

	@Override
	public boolean isTransient() {
		return false;
	}

}
