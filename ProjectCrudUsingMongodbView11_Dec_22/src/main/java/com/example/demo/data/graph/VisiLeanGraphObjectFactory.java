package com.example.demo.data.graph;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.demo.common.RandomGUID;

public class VisiLeanGraphObjectFactory {
	private static Logger LOGGER = LoggerFactory.getLogger(VisiLeanGraphObjectFactory.class);

    public static <T extends AbstractGraphNodeEntity> T createNodeObjectInstance(Class<T> cls) {

        try {
            T retVal = (T)cls.newInstance();
            retVal.setGuid(new RandomGUID().toString());
            if(LOGGER.isDebugEnabled()) {
                LOGGER.debug(String.format("Created graph node object of type %s with guid %s",
                        cls.getName(), retVal.getGuid()));
            }
            return retVal;
        } catch(InstantiationException ie) {
            LOGGER.error(
                    "InstantiationException - Could not create instance of class " + cls.getName());
            return null;
        } catch(IllegalAccessException iae) {
            LOGGER.error(
                    "IllegalAccessException - Could not create instance of class " + cls.getName());
            return null;
        }

    }

    public static <TStart extends IGraphNodeEntity, TEnd extends IGraphNodeEntity, T extends IGraphRelationEntity<TStart, TEnd>> T createRelationObjectInstance(
            Class<T> cls) {

        try {
            T retVal = (T)cls.newInstance();
            retVal.setGuid(new RandomGUID().toString());
            if(LOGGER.isDebugEnabled()) {
                LOGGER.debug(String.format("Created graph relation object of type %s with guid %s",
                        cls.getName(), retVal.getGuid()));
            }
            return retVal;
        } catch(InstantiationException ie) {
            LOGGER.error(
                    "InstantiationException - Could not create instance of class " + cls.getName());
            return null;
        } catch(IllegalAccessException iae) {
            LOGGER.error(
                    "IllegalAccessException - Could not create instance of class " + cls.getName());
            return null;
        }
    }
}
