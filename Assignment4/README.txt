We were able to sucessfully implement mosaic to run in the UI provided and the script parsing provided. It was not a difficult process outside having to follow all the extensions made to the original classes. Additionally the code/repository sent to us was not very organized and understanding what was actually neeeded was a difficult task. Though this is a negative we do not believe this is a negative to their design or code and is only mentioned for clarity.


In order to add the mosaic feature we had to do the following changes:

View changes to add Mosaic:

	1. Added echoMosaicSucess method to IViewAdvanced Interface for the view to display a sucess message in line with other commands.
	2. Added implementation of echoMosaicSucess to ViewAdvanced implementation of IViewAdvanced Interface.
	3. Added echoMosaicSucess to ViewUI to again display a sucess message in line with other commands.
	4. Added btnMap.get("mosaic").setVisible(true) to method echoLoadSucess in ViewUI to display the new mosaic button upon sucess of loading an image.
	5. Added btnMap.put("mosaic", new JButton("MOSAIC)); to initButtons in ViewUI to add the ability of a mosaic button.
	6. Added panel.add(btnMap.get("mosaic")) and btnMap.get("mosaic").setVisible(false) toshow method in ViewUI to actually add the mosaic button.
	7. Added method setMosaicSeedException in IViewUI and ViewUI to display a message that the number of seeds wanted needs to be an integer when not provided a valid number.
	
	
Controller changes to add Mosaic:

	1. Added formulateMap.put("mosaic", "mosaic ") to generateCommands in ImgControllerImplUI.
	2. Added view.btnMap.get("mosaic").addActionListener(mosaicActionListener()) to initActionListners() in ImageControllerImpUI to process user interaction with the mosaic button in the UI view.
	3. Added private ActioonListener mosaicActionListener() method to ImagCOntrollerImpUI following their brighten action listeners code. This was done to add the functionality behind the action listener for user interaction with the button.
	4. Added case "mosaic": to actionhelper private method in ImControllerImpUI.
	5. Added ACommandAdvanced class Mosaic with execute command to follow their command design pattern.
	6. Added ACommand mosaic = new Mosaic(model, view, in) and super.cMap.put("mosaic", mosaic) to method initCommands in ImageControllerImplAdvanced to add the mosaic command to the controller.
	
Model changes to add Mosaic:

	1. Added method mosaic signature to IImageAdvanced interface.
	2. Added implementation of mosaic to ImageSetAdvanced for the model.
	3. Added ImageObj mosaic(String imageName, String destImageName, int seedValue) to ImageSetAdvanced call the ImageObj mosaic operation implementation.
	4. Added mosaic method to ImageObj for the true mosaic operation on an image.
	
Test changes to add Mosaic:

	1. Added mosaic method in MockModelAdvanced for the MockModel to return information when used to test the controller.
	2. Added echoMosaicSucess to MockViewAdvanced for the MockModel to return sucessful command information when used to test the controller.
	3. Added setMosaicSeedException to MockViewUI for the MockView to return information when used to test the controller.
	3. Added mosaicTest to ImgControllerImplAdvancedTest to test the controller with a mock model and mock view.
	4. Added mosaicTest to ImageSetAdvancedTest to test if the mosaic image operation preforms as expected.
	
	
In order to use the mosaic operation with a script the following can be used.

	1. load in the image with "load imagepath nameToStoreImageAs"
	2. run mosaic operation on image with "mosaic numberOfSeeds currentImageName newImageName"
	3. save the mosaic image with "save destinationToSaveImage nameOfImageToSave"
	

