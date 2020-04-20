package cn.edu.scujcc.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.edu.scujcc.model.Channel;
import cn.edu.scujcc.service.ChannelService;

/**
 * Ƶ���ӿڣ��ṩ�ͻ��˷��ʵ���ڡ�
 * @author mengli
 *
 */
@RestController
@RequestMapping("/channel")
public class ChannelController {
	
	@Autowired
	private ChannelService service;
	/**
	 * ��ȡ����Ƶ��
	 * @return  ����Ƶ����JSON����
	 */
	@GetMapping
	public List<Channel> getAllChannel() {
		return this.service.getAllChannel();
	}
	
	/**
	 * ��ȡһ��ָ��Ƶ����JSON����
	 * @param id  ָ��Ƶ���ı��
	 * @return  id��ӦƵ����JSON����
	 */
	@GetMapping("/{id}")
	public Channel getChannel(@PathVariable int id) {
		return this.service.getChannel(id);
	}
	
	/**
	 * ɾ��һ��ָ����Ƶ��
	 * @param id  ��ɾ��Ƶ���ı��
	 * @return  �ɹ���ʧ�ܵ���Ϣ
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteChannel(@PathVariable int id) {
		boolean result = this.service.deleteChannel(id);
		if (result) {
		return ResponseEntity.ok().body("ɾ���ɹ�666");
		} else {
			return ResponseEntity.ok().body("ɾ��ʧ��");
		}
	}
	
	/**
	 * �½�һ��Ƶ��
	 * @param ���½�Ƶ��������
	 * @return  ������Ƶ������
	 */
	@PostMapping
	public Channel createChannel(@RequestBody Channel c) {
		return this.service.createChannel(c);
	}
	
	@PutMapping
	public Channel updateChannel(@RequestBody Channel c) {
		return this.service.updateChannel(c);
	}
}
