package models.entities.tables;

import java.io.Serializable;

public class RenderConfig implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer idRenderConfig;
	private Integer shadingUnits;
	private Integer tmus;
	private Integer rops;
	private Integer smCount;
	private Integer L1Cache;
	private Integer L2Cache;
	private Integer tensorCores;
	private Integer rtCores;
	
	public RenderConfig(Integer idRenderConfig, Integer shadingUnits, Integer tmus, Integer rops, Integer smCount,
			Integer l1Cache, Integer l2Cache, Integer tensorCores, Integer rtCores) {
		this.idRenderConfig = idRenderConfig;
		this.shadingUnits = shadingUnits;
		this.tmus = tmus;
		this.rops = rops;
		this.smCount = smCount;
		this.L1Cache = l1Cache;
		this.L2Cache = l2Cache;
		this.tensorCores = tensorCores;
		this.rtCores = rtCores;
	}

	public Integer getIdRenderConfig() {
		return idRenderConfig;
	}

	public void setIdRenderConfig(Integer idRenderConfig) {
		this.idRenderConfig = idRenderConfig;
	}

	public Integer getShadingUnits() {
		return shadingUnits;
	}

	public void setShadingUnits(Integer shadingUnits) {
		this.shadingUnits = shadingUnits;
	}

	public Integer getTmus() {
		return tmus;
	}

	public void setTmus(Integer tmus) {
		this.tmus = tmus;
	}

	public Integer getRops() {
		return rops;
	}

	public void setRops(Integer rops) {
		this.rops = rops;
	}

	public Integer getSmCount() {
		return smCount;
	}

	public void setSmCount(Integer smCount) {
		this.smCount = smCount;
	}

	public Integer getL1Cache() {
		return L1Cache;
	}

	public void setL1Cache(Integer l1Cache) {
		L1Cache = l1Cache;
	}

	public Integer getL2Cache() {
		return L2Cache;
	}

	public void setL2Cache(Integer l2Cache) {
		L2Cache = l2Cache;
	}

	public Integer getTensorCores() {
		return tensorCores;
	}

	public void setTensorCores(Integer tensorCores) {
		this.tensorCores = tensorCores;
	}

	public Integer getRtCores() {
		return rtCores;
	}

	public void setRtCores(Integer rtCores) {
		this.rtCores = rtCores;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "RenderConfig [idRenderConfig=" + idRenderConfig + ", shadingUnits=" + shadingUnits + ", tmus=" + tmus
				+ ", rops=" + rops + ", smCount=" + smCount + ", L1Cache=" + L1Cache + ", L2Cache=" + L2Cache
				+ ", tensorCores=" + tensorCores + ", rtCores=" + rtCores + "]";
	}
}
