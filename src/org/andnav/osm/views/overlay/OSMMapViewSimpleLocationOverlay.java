// Created by plusminus on 22:01:11 - 29.09.2008
package org.andnav.osm.views.overlay;

import org.andnav.osm.R;
import org.andnav.osm.adt.GeoPoint;
import org.andnav.osm.views.OSMMapView;
import org.andnav.osm.views.OSMMapView.OpenStreetMapViewProjection;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;

/**
 * 
 * @author Nicolas Gramlich
 *
 */
public class OSMMapViewSimpleLocationOverlay extends OSMMapViewOverlay {
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================
	
	protected final Paint mPaint = new Paint();
	
	protected final Bitmap PERSON_ICON;
	/** Coordinates the feet of the person are located. */
	protected final android.graphics.Point PERSON_HOTSPOT = new android.graphics.Point(24,39);
	
	protected GeoPoint mLocation;

	// ===========================================================
	// Constructors
	// ===========================================================
	
	public OSMMapViewSimpleLocationOverlay(final Context ctx){
		this.PERSON_ICON = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.person);
	}

	// ===========================================================
	// Getter & Setter
	// ===========================================================
	
	public void setLocation(final GeoPoint mp){
		this.mLocation = mp;
	}

	// ===========================================================
	// Methods from SuperClass/Interfaces
	// ===========================================================
	
	@Override
	protected void onDrawFinished(Canvas c, OSMMapView osmv) {
		return;
	}
	
	@Override
	public void onDraw(final Canvas c, final OSMMapView osmv) {
		if(this.mLocation != null){
			final OpenStreetMapViewProjection pj = osmv.getProjection();
			final Point screenCoords = new Point();
			pj.toPixels(this.mLocation, screenCoords);
	
			c.drawBitmap(PERSON_ICON, screenCoords.x - PERSON_HOTSPOT.x, screenCoords.y - PERSON_HOTSPOT.y, this.mPaint);
		}
	}

	// ===========================================================
	// Methods
	// ===========================================================

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================
}
