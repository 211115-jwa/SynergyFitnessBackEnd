package com.revature.SynergyFitness.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.SynergyFitness.Beans.Media;
import com.revature.SynergyFitness.Beans.Post;
import com.revature.SynergyFitness.data.MediaRepository;
import com.revature.SynergyFitness.data.PersonRepository;
import com.revature.SynergyFitness.data.PostRepository;

@Service
public class TrainerServiceImpl implements TrainerService{
	private PersonRepository personRepo;
	private PostRepository postRepo;
	private MediaRepository mediaRepo;
	
	@Autowired
	public TrainerServiceImpl(PersonRepository personRepo, PostRepository postRepo, MediaRepository mediaRepo) {
		this.personRepo = personRepo;
		this.postRepo = postRepo;
		this.mediaRepo = mediaRepo;
	}
	@Override
	@Transactional
	public int addPost(Post newPost) {
		return postRepo.save(newPost).getPostId();
	}

	@Override
	@Transactional
	public Post editPost(Post postToEdit) {
		Post postFromDatabase = postRepo.findById(postToEdit.getPostId()).get();
		if (postFromDatabase !=null) {
			postRepo.save(postToEdit);
			return postRepo.findById(postToEdit.getPostId()).get();		
		}
		return null;
	}

	@Override
	@Transactional
	public Post deletePost(Post postToDelete) {
		Post postFromDatabase = postRepo.findById(postToDelete.getPostId()).get();
		if (postFromDatabase !=null) {
		return postRepo.delete(postToDelete).getPostId();
	}

	@Override
	@Transactional
	public int addVideo(Media MediaToAdd) {
		return mediaRepo.save(MediaToAdd).getMediaId();
	}
		
	@Override
	@Transactional
	public Media editVideo(Media mediaToEdit) {
		Media mediaFromDatabase = mediaRepo.findById(mediaToEdit.getMediaId()).get();
		if (mediaFromDatabase !=null) {
			mediaRepo.save(mediaToEdit);
			return mediaRepo.findById(mediaToEdit.getMediaId()).get();		
		}
		return null;
	}

	@Override
	@Transactional
	public Media deleteVideo(Media mediaToRemove) {
		Media mediaFromDatabase = mediaRepo.findById(mediaToRemove.getMediaId()).get();
		if (mediaFromDatabase !=null) {
			return mediaRepo.delete(mediaToRemove).getPostId();
		} 
		return null;

}
