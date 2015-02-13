package Controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;

import View.ChilayLayoutAnimationToolMain;


public class EditorActions 
{
	@SuppressWarnings("serial")
	public static class DeleteAction extends AbstractAction
	{
		/**
		 * 
		 */
		public void actionPerformed(ActionEvent e)
		{
		}
	}
	
	@SuppressWarnings("serial")
	public static class LoadGraphAction extends AbstractAction
	{
		public LoadGraphAction()
		{
			this.putValue(SMALL_ICON, new ImageIcon(this.getClass().getResource("/Icons/open.gif")));
			this.putValue(Action.SHORT_DESCRIPTION, "Load graph from a file");
		}
		
		/**
		 * 
		 */
		private static String lastDirectory = "";
		
		/**
		 * 
		 */
		public void actionPerformed(ActionEvent e)
		{
			JFileChooser chooser = new JFileChooser();
			chooser.setCurrentDirectory(new java.io.File(lastDirectory));
			chooser.setDialogTitle("Load File");
			chooser.setAcceptAllFileFilterUsed(false);

			if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) 
			{
				lastDirectory = chooser.getSelectedFile().getAbsolutePath();
				ChilayLayoutAnimationToolMain.getInstance().loadGraph(chooser.getSelectedFile().getAbsolutePath());
			} 
		}
	}
	
	@SuppressWarnings("serial")
	public static class SaveGraphAction extends AbstractAction
	{
		public SaveGraphAction()
		{
			this.putValue(SMALL_ICON, new ImageIcon(this.getClass().getResource("/Icons/save.gif")));
			this.putValue(Action.SHORT_DESCRIPTION, "Save graph to a file");
		}
		
		/**
		 * 
		 */
		public void actionPerformed(ActionEvent e)
		{
		}
	}
	
	@SuppressWarnings("serial")
	public static class PerformLayoutAction extends AbstractAction
	{
		public PerformLayoutAction()
		{
			//this.putValue(SMALL_ICON, new ImageIcon(this.getClass().getResource("/Icons/layout-cose.gif")));
			this.putValue(SMALL_ICON, new ImageIcon(this.getClass().getResource("/Icons/layout-cose-2.png")));
			this.putValue(Action.SHORT_DESCRIPTION, "Perform layout");
		}
		
		/**
		 * 
		 */
		public void actionPerformed(ActionEvent e)
		{
			ChilayLayoutAnimationToolMain.getInstance().performLayout();
		}
	}
	
	@SuppressWarnings("serial")
	public static class AnimateOnLayoutCheckBoxAction extends AbstractAction
	{
		public AnimateOnLayoutCheckBoxAction()
		{
			this.putValue(Action.SHORT_DESCRIPTION, "Animate during layout");
		}
		
		/**
		 * 
		 */
		public void actionPerformed(ActionEvent e)
		{
			ChilayLayoutAnimationToolMain.getInstance().setAnimateOn(((JCheckBox)e.getSource()).isSelected());
		}
	}
	
	@SuppressWarnings("serial")
	public static class PlayPauseAnimationAction extends AbstractAction
	{
		boolean playOrPauseState = true; //true means play state, false means pause state
		
		public PlayPauseAnimationAction()
		{
			//Initial icon and description
			this.putValue(SMALL_ICON, new ImageIcon(this.getClass().getResource("/Icons/playIcon.png")));
			this.putValue(Action.SHORT_DESCRIPTION, "Play Animation");
		}
		
		/**
		 * 
		 */
		public void actionPerformed(ActionEvent e)
		{
			
			if (playOrPauseState) 
			{
				//Set next icon and description - pause
				this.putValue(SMALL_ICON, new ImageIcon(this.getClass().getResource("/Icons/pauseIcon.png")));
				this.putValue(Action.SHORT_DESCRIPTION, "Pause Animation");
				
				ChilayLayoutAnimationToolMain.getInstance().resumeOrStartAnimation();
			}
			else
			{
				//Set next icon and description - play
				this.putValue(SMALL_ICON, new ImageIcon(this.getClass().getResource("/Icons/playIcon.png")));
				this.putValue(Action.SHORT_DESCRIPTION, "Pause Animation");
				
				ChilayLayoutAnimationToolMain.getInstance().pauseAnimation();
			}
			
			//Set next state
			playOrPauseState = !playOrPauseState;
		}
	}
	@SuppressWarnings("serial")
	public static class ForwardAnimationAction extends AbstractAction
	{		
		public ForwardAnimationAction()
		{
			//Initial icon and description
			this.putValue(SMALL_ICON, new ImageIcon(this.getClass().getResource("/Icons/forwardIcon.png")));
			this.putValue(Action.SHORT_DESCRIPTION, "Fast Forward Animation");
		}
		
		/**
		 * 
		 */
		public void actionPerformed(ActionEvent e)
		{
			ChilayLayoutAnimationToolMain.getInstance().fastForwardAnimation();
		}
	}
	
	@SuppressWarnings("serial")
	public static class RewindAnimationAction extends AbstractAction
	{		
		public RewindAnimationAction()
		{
			//Initial icon and description
			this.putValue(SMALL_ICON, new ImageIcon(this.getClass().getResource("/Icons/rewindIcon.png")));
			this.putValue(Action.SHORT_DESCRIPTION, "Rewind Animation");
		}
		
		/**
		 * 
		 */
		public void actionPerformed(ActionEvent e)
		{
			ChilayLayoutAnimationToolMain.getInstance().rewindAnimation();
		}
	}
	
	@SuppressWarnings("serial")
	public static class StopAction extends AbstractAction
	{		
		public StopAction()
		{
			//Initial icon and description
			this.putValue(SMALL_ICON, new ImageIcon(this.getClass().getResource("/Icons/stopIcon.png")));
			this.putValue(Action.SHORT_DESCRIPTION, "Stop Animation");
		}
		
		/**
		 * 
		 */
		public void actionPerformed(ActionEvent e)
		{
			ChilayLayoutAnimationToolMain.getInstance().stopAnimation();
		}
	}
}
