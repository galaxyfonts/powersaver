package com.shane.powersaver.bean.base;

import java.io.Serializable;

import android.os.Parcel;
import android.os.Parcelable;


/**
 *
 * @author shane（https://github.com/lxxgreat）
 * @version 1.0
 * @created 2016-08-07
 */
public class HistoryItemLolipop extends HistoryItem implements Serializable, Parcelable
{

    public static final byte CMD_UPDATE = 0;        // These can be written as deltas
    public static final byte CMD_NULL = -1;
    public static final byte CMD_START = 4;
    public static final byte CMD_CURRENT_TIME = 5;
    public static final byte CMD_OVERFLOW = 6;
    public static final byte CMD_RESET = 7;

	public byte cmd = CMD_NULL;

	public byte batteryLevel;
	public byte batteryStatus;
	public byte batteryHealth;
	public byte batteryPlugType;

	public short batteryTemperature;
	public char batteryVoltage;

    // Constants from SCREEN_BRIGHTNESS_*
    public static final int STATE_BRIGHTNESS_SHIFT = 0;
    public static final int STATE_BRIGHTNESS_MASK = 0x7;
    // Constants from SIGNAL_STRENGTH_*
    public static final int STATE_PHONE_SIGNAL_STRENGTH_SHIFT = 3;
    public static final int STATE_PHONE_SIGNAL_STRENGTH_MASK = 0x7 << STATE_PHONE_SIGNAL_STRENGTH_SHIFT;
    // Constants from ServiceState.STATE_*
    public static final int STATE_PHONE_STATE_SHIFT = 6;
    public static final int STATE_PHONE_STATE_MASK = 0x7 << STATE_PHONE_STATE_SHIFT;
    // Constants from DATA_CONNECTION_*
    public static final int STATE_DATA_CONNECTION_SHIFT = 9;
    public static final int STATE_DATA_CONNECTION_MASK = 0x1f << STATE_DATA_CONNECTION_SHIFT;

    // These states always appear directly in the first int token
    // of a delta change; they should be ones that change relatively
    // frequently.
    public static final int STATE_CPU_RUNNING_FLAG = 1<<31;
    public static final int STATE_WAKE_LOCK_FLAG = 1<<30;
    public static final int STATE_GPS_ON_FLAG = 1<<29;
    public static final int STATE_WIFI_FULL_LOCK_FLAG = 1<<28;
    public static final int STATE_WIFI_SCAN_FLAG = 1<<27;
    public static final int STATE_WIFI_MULTICAST_ON_FLAG = 1<<26;
    public static final int STATE_MOBILE_RADIO_ACTIVE_FLAG = 1<<25;
    // These are on the lower bits used for the command; if they change
    // we need to write another int of data.
    public static final int STATE_SENSOR_ON_FLAG = 1<<23;
    public static final int STATE_AUDIO_ON_FLAG = 1<<22;
    public static final int STATE_PHONE_SCANNING_FLAG = 1<<21;
    public static final int STATE_SCREEN_ON_FLAG = 1<<20;
    public static final int STATE_BATTERY_PLUGGED_FLAG = 1<<19;
    public static final int STATE_PHONE_IN_CALL_FLAG = 1<<18;
    public static final int STATE_BLUETOOTH_ON_FLAG = 1<<16;
    public static final int MOST_INTERESTING_STATES =
        STATE_BATTERY_PLUGGED_FLAG | STATE_SCREEN_ON_FLAG
        | STATE_PHONE_IN_CALL_FLAG | STATE_BLUETOOTH_ON_FLAG;

    public HistoryItemLolipop(Long time, Byte cmd, Byte batteryLevel, Byte batteryStatusValue,
    		Byte batteryHealthValue, Byte batteryPlugTypeValue,
    		String batteryTemperatureValue,	String batteryVoltageValue,
    		Integer	statesValue)
    {
    	super(time, cmd, batteryLevel, batteryStatusValue,
    		batteryHealthValue, batteryPlugTypeValue,
    		batteryTemperatureValue, batteryVoltageValue,
    		statesValue);
    }



	/**
	 * @return true is phone is charging
	 */
	public boolean isCharging()
	{
		boolean bCharging = (m_statesValue & STATE_BATTERY_PLUGGED_FLAG) != 0;

		return bCharging;
	}

	/**
	 * @return true if screen is on
	 */
	public boolean isScreenOn()
	{
		boolean bScreenOn = (m_statesValue & STATE_SCREEN_ON_FLAG) != 0;
		return bScreenOn;
	}

	/**
	 * @return true is GPS is on
	 */
	public boolean isGpsOn()
	{
		boolean bGpsOn = (m_statesValue & STATE_GPS_ON_FLAG) != 0;
		return bGpsOn;
	}

	/**
	 * @return true is wifi is running
	 */
	public boolean isWifiRunning()
	{
		boolean bWifiRunning = (m_statesValue & STATE_WIFI_RUNNING_FLAG) != 0;
		return bWifiRunning;
	}

	/**
	 * @return true is a wakelock is present
	 */
	public boolean isWakeLock()
	{
		boolean bWakeLock = (m_statesValue & STATE_WAKE_LOCK_FLAG) != 0;
		return bWakeLock;
	}

	/**
	 * @return true  if Phone is in Call
	 */
	public boolean isPhoneInCall()
	{

		boolean bPhoneInCall = (m_statesValue & STATE_PHONE_IN_CALL_FLAG) != 0;

		return bPhoneInCall;
	}

	/**
	 * @return true if Phone is Scanning
	 */
	public boolean isPhoneScanning()
	{
		boolean bPhoneScanning = (m_statesValue & STATE_PHONE_SCANNING_FLAG) != 0;

		return bPhoneScanning;
	}

	/**
	 * @return the true if bluetooth is on
	 */
	public boolean isBluetoothOn()
	{
		boolean bBluetoothOn = (m_statesValue & STATE_BLUETOOTH_ON_FLAG) != 0;

		return bBluetoothOn;
	}

	private HistoryItemLolipop(Parcel in) {
		super(in);
	}

	public static final Parcelable.Creator<HistoryItemLolipop> CREATOR
			= new Parcelable.Creator<HistoryItemLolipop>() {

		@Override
		public HistoryItemLolipop createFromParcel(Parcel in) {
			return new HistoryItemLolipop(in);
		}

		@Override
		public HistoryItemLolipop[] newArray(int size) {
			return new HistoryItemLolipop[size];
		}

	};

}
